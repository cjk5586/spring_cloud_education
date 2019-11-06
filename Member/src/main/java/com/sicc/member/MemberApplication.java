package com.sicc.member;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import com.sicc.member.util.UserContextFilter;

/**
 * Member Micro Service
 * 사용자 관련 마이크로서비스
 * @author Woongs
 */
@EnableFeignClients		// feign 사용
@EnableEurekaClient		// eureka client
@EnableCircuitBreaker	// hysrix circuitbreaker 사용
@EnableResourceServer	// TODO S3-6-2-1 resource server 선언
@SpringBootApplication
public class MemberApplication {
	// TODO S3-6-7-1 UserContextFilter를 Member 마이크로서비스에 적용
	@Bean
	public Filter UserContextFilter() {
		UserContextFilter userContextFilter = new UserContextFilter();
		return userContextFilter;
	}
	
	@LoadBalanced
	@Bean // work 마이크로서비스와 통신을 위한 RestTemplate
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}