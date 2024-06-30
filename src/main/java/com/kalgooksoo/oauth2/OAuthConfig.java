package com.kalgooksoo.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalgooksoo.oauth2.client.NaverOAuthClient;
import com.kalgooksoo.oauth2.properties.NaverOAuthProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OAuthConfig {

    private final NaverOAuthProperties naverOAuthProperties;

    public OAuthConfig(NaverOAuthProperties naverOAuthProperties) {
        this.naverOAuthProperties = naverOAuthProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public NaverOAuthClient naverOAuthClient() {
        return new NaverOAuthClient(
                restTemplate(),
                objectMapper(),
                naverOAuthProperties.getClientId(),
                naverOAuthProperties.getClientSecret(),
                naverOAuthProperties.getRedirectUri()
        );
    }

}
