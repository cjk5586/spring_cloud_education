package com.sicc.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 사용자 관련 마이크로서비스 시작점
 * @author Woongs
 */
@SpringBootApplication
public class MemberApplication {
	// hello works?
	// TODO S1-2-1-1 Work 마이크로서비스와 통신을 위한 RestTemplate
	@Bean 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}