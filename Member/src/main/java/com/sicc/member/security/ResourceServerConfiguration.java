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
			// resource에 접근시 모든 역할 가능
			.antMatchers("/resource/**").permitAll()
			// GET 요청으로 /member/** 접근시 USER, ADMIN 역할만 요청 가능
			.antMatchers(HttpMethod.GET, "/member/**").hasAnyRole("USER", "ADMIN")
			// POST 요청으로 /member/** 접근시 ADMIN 역할만 요청 가능
			.antMatchers(HttpMethod.POST, "/member/**").hasRole("ADMIN")
		.anyRequest().authenticated(); // 모든 요청은 인증받은 사용자만
	}
}
