package com.sicc.oauthserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 서명키값 관리하는 config
 * @author Woongs
 */
@Component
@Configuration
public class ServiceConfig {
	@Value("${signing.key}") // 서명키를 application.yml에서 불러옴
	private String jwtSigningKey = "";
	
	// 서명키를 리턴값 하는 함수
	public String getJwtSigningKey() {
		return jwtSigningKey;
	}
}