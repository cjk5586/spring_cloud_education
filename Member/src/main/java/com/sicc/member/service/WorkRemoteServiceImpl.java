package com.sicc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sicc.member.vo.WorkVO;

/**
 * Work 마이크로서비스 통신을 위한 정의
 * @author Woongs
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {
	public static final String URL = "http://localhost:8082/work/";
	
	@Autowired
	private RestTemplate restTemplate;

	// work 마이크로서비스 정보 가져오기
	@HystrixCommand(fallbackMethod = "getWorkInfoFallback") // TODO S1-3-4-1 hystrix 폴백 선언
	@Override
	public String getWorkInfo(String workNum) {
		WorkVO workVO = new WorkVO();
		ResponseEntity<WorkVO> result = restTemplate.exchange
										(
											URL+"{workNum}",
											HttpMethod.GET,
											null,
											WorkVO.class,
											workNum
										);
		workVO = result.getBody();
		
		return workVO.toString();
	}
	
	// TODO S1-3-4-2 hystrix 폴백 정의
	public String getWorkInfoFallback(String workNum, Throwable t) {
		String errMsg = "[ Work dosen't work. fallback occurs. ] : "+t;
		return errMsg;
	}
}