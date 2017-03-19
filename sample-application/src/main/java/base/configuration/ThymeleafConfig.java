package base.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

//http://blog.codeleak.pl/2016/12/thymeleaf-reload-templates-and-static-resources.html

@Configuration
public class ThymeleafConfig {

    //ServletContextTemplateResolver: It resolves templates with provided prefix and suffix and other settings.
//    @Bean(name ="templateResolver")
    public ClassLoaderTemplateResolver getTemplateResolver(ServletContext servletContext) {
        //here we can use other templates resolvers, like:
        // ServletContextTemplateResolver,
        // SpringResourceTemplateResolver,
        // UrlTemplateResolver,
        // FileTemplateResolver
        // ClassLoaderTemplateResolver
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // avoid '/' at the beginning of the path
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

//    @Bean(name ="templateEngine")
    public SpringTemplateEngine getTemplateEngine(ServletContext servletContext) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver(servletContext));
        templateEngine.addDialect(new LayoutDialect()); // this is not obligatory,
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
