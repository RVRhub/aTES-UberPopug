package com.auth.service.config.security;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	//    private final CustomPasswordEncoder passwordEncoder;
//    private final CustomTokenConverter tokenConverter;
//    private final CustomTokenEnhancer tokenEnhancer;

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
		clients.inMemory()
				.withClient(clientID)
				.authorizedGrantTypes("password", "authorization_code")
				.secret(encoder().encode(clientSecret))
				.scopes("user_info", "read", "write")
				.redirectUris(redirectURLs)
				.autoApprove(false)
		;
	}

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        int tokenValiditySeconds = 60 * 60 * 24 * 30 * 6;
//        clients.inMemory()
//            .withClient(clientID)
//            .scopes("read", "write", "trust", "user_info")
//            .secret(passwordEncoder.encode(clientSecret))
//            .authorizedGrantTypes("authorization_code", "refresh_token", "password")
//
//            .accessTokenValiditySeconds(tokenValiditySeconds)
//            .refreshTokenValiditySeconds(tokenValiditySeconds)
//                .redirectUris(redirectURLs);
//
//    }

	//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter(), tokenEnhancer));
//        endpoints.authenticationManager(authenticationManager)
//            .tokenStore(tokenStore())
//            .tokenEnhancer(tokenEnhancerChain)
//            .pathMapping("/oauth/token", "/api/login");
//    }
//
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter());
		;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("123");
		//        converter.setAccessTokenConverter(tokenConverter);
		return converter;
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
