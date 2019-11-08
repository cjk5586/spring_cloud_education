package com.sicc.member.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign으로 work호출 정의
 * @author Woongs
 */
//@FeignClient(name = "work", url = "http://localhost:8082/") // Feign 만
//@FeignClient(name = "work") // TODO S2-2-1-1 Feign + Eureka + Ribbon
//@FeignClient(name = "work", fallback = FeignWorkRemoteFallback.class) // TODO S2-2-6-1 선언한 Fallback 적용
@FeignClient(name = "work", fallbackFactory = FeignWorkRemoteFallbackFactory.class) // Feign + Eureka + Ribbon
public interface FeignWorkRemoteService {
	@RequestMapping(path = "/work/toString/{workNum}")
	String getWorkInfoByFeign(@PathVariable("workNum") String workNum);
}

