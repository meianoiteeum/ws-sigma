package br.com.sigma.config;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sigma.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();

        Contact contact = new Contact("Guilherme Costa",
                                        "https://www.linkedin.com/in/guilherme-scosta",
                                        "tfguilherme.07@gmail.com");

        ApiInfo apiInfo = new ApiInfoBuilder()
                .description("Teste")
                .contact(contact)
                .build();

        docket.apiInfo(apiInfo);

        return docket;
    }
}
