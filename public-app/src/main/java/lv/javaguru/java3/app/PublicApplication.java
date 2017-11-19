package lv.javaguru.java3.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"lv.javaguru.java3.app"})
public class PublicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicApplication.class, args);
    }

}
