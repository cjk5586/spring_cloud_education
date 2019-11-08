package com.sicc.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

// TODO S1-7-5-1 HystrixDashboard 클래스 생성
/**
 * Circuit, Thread Pool 가시화를 위한 대쉬보드 마이크로서비스 
 * @author Woongs
 */
@SpringBootApplication
// TODO S1-7-6-3 해당 마이크로서비스를 HystrixDashboard로 선언
@EnableHystrixDashboard
public class HystrixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}