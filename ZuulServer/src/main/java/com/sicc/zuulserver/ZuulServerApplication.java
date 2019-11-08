package com.sicc.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// TODO S2-3-2-1 Zuul Proxy Server, Eureka Client 선언
@EnableZuulProxy		// Zuul Proxy Server
@EnableDiscoveryClient	// Eureka Client
@SpringBootApplication
// TODO S2-3-1-1 API Gateway 역할을 수행할 마이크로 서비스 생성
public class ZuulServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
}
