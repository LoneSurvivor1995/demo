package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Environment environment;
    public SwaggerConfig(Environment environment){
        this.environment = environment;
    }
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title(environment.getProperty("swagger.apiInfo.title"))
                .description(environment.getProperty("swagger.apiInfo.description"))
                .termsOfServiceUrl(environment.getProperty("swagger.apiInfo.termsOfServiceUrl"))
                .version(environment.getProperty("swagger.apiInfo.version"))
                .build();
    }

//    private ApiInfo apiInfo() {
//        Contact contact = new Contact(env.getProperty(ConstantSwagger2.CONTACT_NAME),
//                env.getProperty(ConstantSwagger2.CONTACT_URL),
//                env.getProperty(ConstantSwagger2.CONTACT_EMAIL));
//        return new ApiInfoBuilder()
//                .title(env.getProperty(ConstantSwagger2.API_INFO_TITLE))
//                .description(env.getProperty(ConstantSwagger2.API_INFO_DESCRIPTION))
//                .version(env.getProperty(ConstantSwagger2.API_INFO_VERSION))
//                .termsOfServiceUrl(env.getProperty(ConstantSwagger2.API_INFO_TERMS_OF_SERVICE_URL))
//                .contact(contact)
//                .build();
}
