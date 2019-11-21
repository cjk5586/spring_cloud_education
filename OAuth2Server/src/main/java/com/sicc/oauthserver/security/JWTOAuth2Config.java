package com.sicc.oauthserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import java.util.Arrays;

@Configuration
public class JWTOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private DefaultTokenServices tokenServices;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));

        endpoints
    		.tokenStore(tokenStore)							// 생성된 JWT 토큰을 저장
            .accessTokenConverter(jwtAccessTokenConverter)	// JWT와 OAuth2 서버 사이의 변환기로 동작 (토큰 생성)  
            .tokenEnhancer(tokenEnhancerChain)              // JWT 토큰을 쉽게 확장 할때 사용 (추가정보 setting 가능)
            .authenticationManager(authenticationManager)	// OAuth2
            .userDetailsService(userDetailsService);		// OAuth2
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
	    	.inMemory()	// DB연결 여부
	    	.withClient("sicc_client")	// 클라이언트 명칭
	    	.secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("sicc_secret"))	// 암호 인코드
	    	.authorizedGrantTypes("refresh_token", "password", "client_credentials")	// 권한 타입
	    	.scopes("webclient", "mobileclient");	// 범위
    }
}