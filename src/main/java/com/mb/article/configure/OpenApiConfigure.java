package com.mb.article.configure;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigure {
    private static final String HEADER_TOKEN = "token";
    private static final String HEADER_BEARER = "bearer"; // bearer

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(HEADER_BEARER))
                .components(new Components()
                        .addSecuritySchemes(HEADER_BEARER, securityScheme("Authentication")));
                        // .addSecuritySchemes(HEADER_BEARER, securityScheme("x-api-key")));
    }

    private SecurityScheme securityScheme(String name) {
        return new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .name(name);
    }
}
