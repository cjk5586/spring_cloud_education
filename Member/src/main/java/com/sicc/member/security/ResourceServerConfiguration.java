package com.sicc.member.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 보호 자원 서비스 접근 대상, 역할 설정
 * @author Woongs
 */
// TODO S3-6-8-1 보호자원 마이크로서비스(Member)에 대한 접근 대상, 역할 설정
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated();
	}
}
