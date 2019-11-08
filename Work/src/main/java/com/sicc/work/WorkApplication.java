package com.sicc.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Work Micro Service
 * 업무 관련 마이크로서비스
 * @author Woongs
 */
@EnableEurekaClient // TODO S1-11-1-2 eureka-client
@SpringBootApplication
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

}
