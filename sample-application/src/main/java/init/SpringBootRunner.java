package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Dodatkowe parametry sa zdefiniowane w pliku resources/application.properties lub application-dev.properties
 *
 *  To run this app: mvn spring-boot:run -Drun.profiles=dev
 *
 * Niestety nie działa dobrze gdy uruchamiana jest metoda main()
 */
@SpringBootApplication
@ComponentScan(basePackages = { "base" })
public class SpringBootRunner {

    public static void main(String[] args) {
        // System.setProperty("spring.profiles.active", "dev"); // to działa ale lepiej podać w configuracji
        // or add in IntelliJ Run -> Edit Configuration -> VM Options: -Dspring.profiles.active=dev
        SpringApplication.run(new Class[] {SpringBootRunner.class}, args);
    }

}
