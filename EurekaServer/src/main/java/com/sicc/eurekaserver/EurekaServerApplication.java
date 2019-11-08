package com.sicc.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Erueka Server
 * @author Woongs
 */
// TODO S1-10-1-1 Eureka Server 마이크로서비스 생성
@SpringBootApplication
// TODO S1-10-2-2 해당 마이크로서비스가 Eureka Server임을 선언
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
