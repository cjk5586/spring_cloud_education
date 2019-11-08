package com.sicc.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Member Micro Service
 * 사용자 관련 마이크로서비스
 * @author Woongs
 */
@EnableFeignClients		// TODO S2-1-3-2 feign 사용
@EnableEurekaClient		// eureka client
@EnableCircuitBreaker	// hysrix circuitbreaker 사용
@SpringBootApplication
public class MemberApplication {
	@LoadBalanced
	@Bean // work 마이크로서비스와 통신을 위한 RestTemplate
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
}