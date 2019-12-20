package com.sicc.banana;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/banana")
@RefreshScope
public class BananaApplication {
	@Value("${test.message}")
	public String msg;
	
	@RequestMapping("/index")
	public String index() {
		return msg;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BananaApplication.class, args);
	}

}
