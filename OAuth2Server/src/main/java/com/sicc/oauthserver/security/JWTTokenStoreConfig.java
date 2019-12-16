package com.sicc.oauthserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.sicc.oauthserver.config.ServiceConfig;

/**
 * JWT 토큰을 생성, 서명, 변환을 관리하는 방법을 정의
 * @author Woongs
 */
@Configuration
public class JWTTokenStoreConfig {
    @Autowired
    private ServiceConfig serviceConfig;

    // JWT와 OAuth2 서버 사이의 변환기로 동작 (토큰 생성) --- 1
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(serviceConfig.getJwtSigningKey()); // converter에 서명키 셋팅
        return converter;
    }
    
    // 생성된 JWT 토큰 저장 --- 2
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    // 서비스에 전달된 토큰에서 데이터를 읽는데 사용 (토큰 해석) --- 3
    @Bean
    @Primary // 특정 타입의 빈이 둘이상일때 자동 주입하도록 설정하는 역할
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return new JWTTokenEnhancer();
    }
}
