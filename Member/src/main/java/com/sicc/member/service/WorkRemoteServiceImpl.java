package com.sicc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sicc.member.repostiroy.MemberRepository;
import com.sicc.member.vo.MemberVO;
import com.sicc.member.vo.WorkVO;

/**
 * Work 마이크로서비스 통신을 위한 정의
 * @author Woongs
 */
@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {
	// TODO S1-8-2-3 기존 URL 주석처리, 새로운 URL 추가
	//public static final String URL = "http://localhost:8082/work/";
	public static final String URL = "http://work/work/";
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MemberRepository memberRepository;
	
	// work 마이크로서비스 정보 가져오기
	@HystrixCommand(commandKey = "getWorkInfo", fallbackMethod = "getWorkInfoFallback") // hystrix 폴백 선언
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
	
	// work 마이크로서비스 정보 가져오기 폴백
	public String getWorkInfoFallback(String workNum, Throwable t) {
		String errMsg = "[ Work dosen't work. getWorkInfo fallback occurs. ] : "+t;
		return errMsg;
	}
	
	// member, work 마이크로서비스 정보 가져오기	
	@HystrixCommand(commandKey = "getMemberAndWorkInfo", fallbackMethod = "getMemberAndWorkInfoFallback") // hystrix 폴백 선언
	public String getMemberAndWorkInfo(String sabun, String workNum) {
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
		
		MemberVO memberVO = new MemberVO();
		memberVO = memberRepository.findBySabun(sabun);
		
		return memberVO.toString()+workVO.toString();
	}
	
	// member, work 마이크로서비스 정보 가져오기 폴백
	public String getMemberAndWorkInfoFallback(String sabun, String workNum, Throwable t) {
		String errMsg = "[ Work dosen't work. getMemberAndWork fallback occurs. ] : "+t;
		return errMsg;
	}
}