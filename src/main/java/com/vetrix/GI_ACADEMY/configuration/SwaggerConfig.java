package com.vetrix.GI_ACADEMY.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI custumOpenApi(){
        return new OpenAPI()
                .components(new Components().addSecuritySchemes(
                        "jwt",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info().title("GI ACADEMY")
                        .version("1.0")
                        .description("Documentation de L'API de la platforme GI ACADEMY"))
                .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));
    }
}