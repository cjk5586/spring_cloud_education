package com.sicc.member.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sicc.member.vo.WorkVO;

/**
 * Feign으로 work호출 정의
 * @author Woongs
 */
// TODO S2-1-4-1 Feign 사용을 위한 인터페이스 생성
@FeignClient(name = "work", url = "http://localhost:8082/")
public interface FeignWorkRemoteService {
	@RequestMapping(path = "/work/toString/{workNum}")
	String getWorkInfoByFeign(@PathVariable("workNum") String workNum);
}
