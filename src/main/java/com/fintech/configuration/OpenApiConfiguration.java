package com.fintech.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {


    @Value("${springdoc.oAuthFlow.authorization-url}")
    private String authorizationUrl;

    @Value("${springdoc.oAuthFlow.token-url}")
    private String tokenUrl;

    @Value("${springdoc.oAuthFlow.client-id}")
    private String clientId;

    @Value("${springdoc.oAuthFlow.client-secret}")
    private String clientSecret;

    @Bean
    public OpenAPI customOpenAPI(@Value("${application.version}") String appVersion) {

        OAuthFlow passwordFlow = new OAuthFlow()
                .authorizationUrl(authorizationUrl)
                .tokenUrl(tokenUrl);

        /*
//          Client Credentials Grant Flow
        OAuthFlow clientCredentialsFlow = new OAuthFlow()
                .tokenUrl(tokenUrl)
                .clientId(clientId)
                .clientSecret(clientSecret);
        */

        return new OpenAPI()
                .components(new Components()
                                .addSecuritySchemes("security_auth", new SecurityScheme()

                                                .type(SecurityScheme.Type.OAUTH2)
                                                .flows(new OAuthFlows().password(passwordFlow))
//                                        .flows(new OAuthFlows().password(clientCredentialsFlow)) // for credentialsFlow
                                )
                )
                .info(new Info().title("Server Side Gateway APIs")
                        .description("")
                        .version(appVersion)
                        .license(new License().name("Contact FintechTeam").url("mailto:info@fintech.com")));
    }
}
