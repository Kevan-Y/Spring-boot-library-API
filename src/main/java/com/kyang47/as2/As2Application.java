package com.kyang47.as2;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class As2Application {
    public static void main(String[] args) {
        SpringApplication.run(As2Application.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Library API").version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .description("JAC 555 Assignment 2, mimic a library"));
    }
}
