package com.kalgooksoo.oauth2.client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaverOAuthClientTest {

    @Autowired
    private NaverOAuthClient naverOAuthClient;

    @Test
    @DisplayName("빈 등록 테스트")
    void registBeanTest() {
        assertNotNull(naverOAuthClient);
    }

    @Test
    void getRedirectUri() {
        // When
        String redirectUri = naverOAuthClient.getRedirectUri();

        // Then
        assertNotNull(redirectUri);
    }

    @Test
    void getAccessToken() {
        // When

    }

    @Test
    void authenticate() {
    }
}