package base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

/**
 * @Configuration - this annotation indicates a class that plays the same role as xml file containing bean definitions.
 *
 * @EnableWebMvc - this annotation imports the Spring MVC configuration from {@link WebMvcConfigurationSupport}.
 * To customize the imported configuration, implement the interface {@link WebMvcConfigurer} or more likely extend the empty method
 * of the base class {@link WebMvcConfigurerAdapter} and override individual methods.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /*
    * In Spring MVC requested content type is determined in the following order:
    *
    * 1. file extension like this: (default on)
    * http://myserver/myapp/mydata/list.html -> will map into html content-type
    *
    * 2. URL parameter like this: (default off)
    * http://myserver/myapp/mydata/list?format=xls
    * The name of the parameter is format by default, but this may be changed.
    *
    * 3. 'Accept' HTTP header like this: (default off)
    * Accept: application/json
    *
    * The order cannot be changed. Single steps can only be turned on and off.
    */
    @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
        configurer.favorParameter(true);
        configurer.ignoreAcceptHeader(false);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);

        // below properties have effect when request param strategy is used
        configurer.parameterName("mediaType");
        configurer.mediaType("xml", MediaType.APPLICATION_XML);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // this adds a handler for static resources, plus resource location config
        registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //start Thymeleaf specific configuration


    //ServletContextTemplateResolver: It resolves templates with provided prefix and suffix and other settings.
    @Bean(name ="templateResolver")
    public ServletContextTemplateResolver getTemplateResolver(ServletContext servletContext) {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    //SpringTemplateEngine: It processes templates. We need to assign ServletContextTemplateResolver instance to it. Bean name must be templateEngine.
    @Bean(name ="templateEngine")
    public SpringTemplateEngine getTemplateEngine(ServletContext servletContext) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver(servletContext));
        return templateEngine;
    }

    //ThymeleafViewResolver: It runs after controller ends its execution. It receives the view name to be processed.
    @Bean(name="viewResolver")
    public ThymeleafViewResolver getViewResolver(ServletContext servletContext){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(getTemplateEngine(servletContext));
        viewResolver.setOrder(1);
        return viewResolver;
    }




}
