package com.auth.service.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

import com.auth.service.config.security.jwt.CustomTokenConverter;
import com.auth.service.config.security.jwt.CustomTokenEnhancer;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final CustomPasswordEncoder passwordEncoder;
    private final CustomTokenConverter tokenConverter;
    private final CustomTokenEnhancer tokenEnhancer;

    @Value("${auth-service.oauth.clientId}")
    private String clientID;
    @Value("${auth-service.oauth.clientSecret}")
    private String clientSecret;
    @Value("${auth-service.oauth.redirectUris}")
    private String redirectURLs;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        int tokenValiditySeconds = 60 * 60 * 24 * 30 * 6;
        clients.inMemory()
            .withClient(clientID)
            .scopes("read", "write", "trust", "user_info")
            .secret(passwordEncoder.encode(clientSecret))
            .authorizedGrantTypes("authorization_code", "refresh_token", "password")

            .accessTokenValiditySeconds(tokenValiditySeconds)
            .refreshTokenValiditySeconds(tokenValiditySeconds)
                .redirectUris(redirectURLs);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter(), tokenEnhancer));
        endpoints.authenticationManager(authenticationManager)
            .tokenStore(tokenStore())
            .tokenEnhancer(tokenEnhancerChain)
            .pathMapping("/oauth/token", "/api/login");
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        converter.setAccessTokenConverter(tokenConverter);
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
