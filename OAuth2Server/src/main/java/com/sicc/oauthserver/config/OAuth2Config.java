package com.sicc.oauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * OAuth2 서비스에 등록된 어플리케이션과 사용자 자격 증명을 정의
 * @author Woongs
 */
@Configuration	// TODO S3-2-1-1 AuthorizationServerConfigurerAdapter를 확장
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;	// TODO S3-2-1-2 
	
	@Autowired
	private UserDetailsService userDetailsService;	// TODO S3-2-1-3 
	
	@Override	// TODO S3-2-1-4 서비스에 등록될 클라이언트를 정의하는 configure() 메소드 재정의
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()	// DB연결 여부 (.jdbc() 가능)
			.withClient("sicc_client")	// 클라이언트 명칭
			.secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("sicc_secret"))	// 암호 인코드
			.authorizedGrantTypes("refresh_token", "password", "client_credentials")	// 권한 타입
			.scopes("webclient", "mobileclient");	// 범위
	}
	
	@Override	// TODO S3-2-1-5 스프링에 기본 인증 관리자와 스프링과 함께 제공되는 사용자 상세 서비스를 이용한다고 알림
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}
}
