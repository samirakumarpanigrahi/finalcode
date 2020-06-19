package com.mindtree.ShoppingCart.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.net.HttpHeaders;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
                .paths(postPaths()).build();
    }



    private Predicate<String> postPaths() {
        return regex("/.*");
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service").version("1.0").build();
    }
}