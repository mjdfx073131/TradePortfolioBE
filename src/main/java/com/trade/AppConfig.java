package com.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;



@SpringBootApplication
@Import(SwaggerConfig.class)
@ComponentScan // required in order for tests to pick up @Components
public class AppConfig {
    public static void main(String[] args) {
        // try auto build on jenkins
        SpringApplication.run(AppConfig.class, args);
    }

}

