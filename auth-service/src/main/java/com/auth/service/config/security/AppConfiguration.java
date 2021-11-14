//package com.auth.service.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//@Configuration
//public class AppConfiguration {
//
//    @Bean
//    public CustomPasswordEncoder passwordEncoder() {
//        return new CustomPasswordEncoder();
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices(TokenStore tokenStore) {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore);
//        defaultTokenServices.setSupportRefreshToken(true);
//        return defaultTokenServices;
//    }
//}
