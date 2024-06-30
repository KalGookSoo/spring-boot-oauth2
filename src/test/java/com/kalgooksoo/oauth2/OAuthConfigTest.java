package com.kalgooksoo.oauth2;

import com.kalgooksoo.oauth2.properties.NaverOAuthProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OAuthConfigTest {

    @Autowired
    private NaverOAuthProperties naverOAuthProperties;

    @Test
    @DisplayName("빈 등록 테스트")
    void registBeanTest() {
        assertNotNull(naverOAuthProperties);
    }

}