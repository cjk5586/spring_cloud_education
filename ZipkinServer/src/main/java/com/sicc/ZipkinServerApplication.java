package com.sicc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import zipkin2.server.internal.EnableZipkinServer;
import zipkin2.server.internal.RegisterZipkinHealthIndicators;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
	static {
		System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZipkinServerApplication.class).listeners(new RegisterZipkinHealthIndicators())
				.properties("spring.config.name=zipkin-server").run(args);
	}
}
