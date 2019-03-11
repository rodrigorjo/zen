package com.example.zen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by s2it_dsilva
 * @since 8/30/18.
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    

    @Value("${enableSwaggerApi:true}")
    private boolean enableSwaggerApi;

    /**
     * Configura o swagger, acesse via <HOST>:<PORTA>/swagger-ui.html
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("auditDocket")//
                .select() //
                .apis(RequestHandlerSelectors.any()) //
                .paths(PathSelectors.any()) //
                .build()//
                .apiInfo(
                        new ApiInfoBuilder().title("Audit Producer")
                                .description("API responsavel pela producao de mensagens de auditoria para o kafka")
                                .build())
                .enable(true);
    }

}
