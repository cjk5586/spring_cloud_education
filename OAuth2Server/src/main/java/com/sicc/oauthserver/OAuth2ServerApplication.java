package com.sicc.oauthserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient		// TODO S3-1-3-1 eureka-client 
@RestController				// TODO S3-1-3-2 Rest Controller 
@EnableResourceServer		// TODO S3-1-3-3 Resource server
@EnableAuthorizationServer	// TODO S3-1-3-4 Authorization server
@SpringBootApplication
public class OAuth2ServerApplication {
	// TODO S3-1-3-5 이 엔드포인트는 보호 서비스로 호출 되어 OAuth2 액세스 토큰의 유효성을 검증하고 보호 서비스에 접근하는 할당된 사용자 역할을 조회
	@RequestMapping(value = {"/user"}, produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		return userInfo;
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerApplication.class, args);
	}
}

