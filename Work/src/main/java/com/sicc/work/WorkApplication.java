package com.sicc.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * Work Micro Service 업무 관련 마이크로서비스
 * 
 * @author Woongs
 */
@SpringBootApplication
public class WorkApplication {
	// zipkin server와 연결을 위한 선언
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

}
