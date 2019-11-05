package com.sicc.oauthserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 어플리케이션에 대한 사용자 ID, 패스워드, 역할 정의
 * @author Woongs
 */
@Configuration // TODO S3-3-5-1 핵심 스프링 스큐리티의 WebSecurityConfigurerAdapter 확장
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	@Bean	// TODO S3-3-5-2 authenticationManagerBean은 스프링 시큐리티가 인증을 처리하는데 사용
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	@Bean	// TODO S3-3-5-3 userDetailsServices는 스프링 시큐리티에서 반환될 사용자 정보를 저장
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}
	@Override	// TODO S3-3-5-4 어플리케이션에 대한 사용자, 패스워드, 역할 정의
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth
			.inMemoryAuthentication()
			.passwordEncoder(encoder)
			.withUser("sicc_msa_user")	// 사용자
				.password(encoder.encode("password1"))	// 패스워드
				.roles("USER")	// 역할
			.and()
			.withUser("sicc_msa_leader")	// 사용자
				.password(encoder.encode("password2"))	// 패스워드
				.roles("USER", "ADMIN");	// 역할
	}
}
