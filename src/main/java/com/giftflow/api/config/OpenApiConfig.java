package com.giftflow.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI giftFlowOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("GiftFlow Api")
            .description("GiftFlow backend API documentation")
            .version("v1")

        );
    }
}
