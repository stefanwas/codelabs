package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Dodatkowe parametry sa zdefiniowane w pliku resources/application.properties
 * To run this app: mvn spring-boot:run
 * Niestety nie działa dobrze gdy uruchamiana jest metoda main()
 */
@SpringBootApplication
@ComponentScan(basePackages = { "base" })
public class SpringBootRunner {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {SpringBootRunner.class}, args);
    }

}
