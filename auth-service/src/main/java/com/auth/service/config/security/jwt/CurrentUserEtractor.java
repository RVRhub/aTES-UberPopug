package com.auth.service.config.security.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CurrentUserEtractor {

    private static final String ACCESS_ID = "user_name";

    public CurrentUser extractUserFromToken() {
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) details;
        Object decodedDetails = oAuth2AuthenticationDetails.getDecodedDetails();
        Map map = (Map) decodedDetails;
        String accessId = (String) map.get(ACCESS_ID);
        return new CurrentUser(accessId);
    }
}
