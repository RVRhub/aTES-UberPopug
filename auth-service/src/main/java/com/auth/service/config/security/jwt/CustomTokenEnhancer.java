//package com.auth.service.config.security.jwt;
//
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class CustomTokenEnhancer implements TokenEnhancer {
//
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        Map<String, Object> additionalInformation = new HashMap<>();
//        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
//        return accessToken;
//    }
//
//
//}
