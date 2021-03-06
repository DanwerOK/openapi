package com.ponodan.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // http://localhost:8080/v2/api-docs
    // http://localhost:8080/swagger-ui.html
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ponodan.openapi"))
                .paths(regex("/product.*"))
                .build();
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "JLand Nepr presentation REST API",
                "Spring Boot REST API for OAS demo",
                "1.0",
                "Terms of service",
                "DanwerOK",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

        return apiInfo;
    }
}