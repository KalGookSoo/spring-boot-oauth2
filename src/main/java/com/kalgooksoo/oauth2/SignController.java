package com.kalgooksoo.oauth2;

import com.kalgooksoo.oauth2.client.NaverOAuthClient;
import com.kalgooksoo.oauth2.provider.OAuth2UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final NaverOAuthClient naverOAuthClient;

    public SignController(NaverOAuthClient naverOAuthClient) {
        this.naverOAuthClient = naverOAuthClient;
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign_in";
    }

    @GetMapping("/oauth2/naver/login")
    public String oauth2NaverLogin() {
        return "redirect:" + naverOAuthClient.getRedirectUri();
    }

    @RequestMapping(value = "/oauth2/naver/callback", method = {RequestMethod.GET, RequestMethod.POST})
    public String oauth2NaverCallback(@RequestParam("code") String code) {
        String accessToken = naverOAuthClient.getAccessToken(code);
        OAuth2UserDetail userDetail = naverOAuthClient.authenticate(accessToken);
        logger.info(userDetail.toString());
        return "redirect:/";
    }

}
