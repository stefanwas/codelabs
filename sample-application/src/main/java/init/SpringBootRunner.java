package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "base" })
@EnableAutoConfiguration
public class SpringBootRunner {
  public static void main(String[] args) {
    SpringApplication.run(new Class[] {SpringBootRunner.class}, args);
  }
}
