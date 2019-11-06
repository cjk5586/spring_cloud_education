package com.sicc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
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
	// TODO S3-7-3-1 기존 URL 주석 처리
	// public static final String URL = "http://localhost:8082/work/";
	// public static final String URL = "http://work/work/";
	// public static final String URL = "http://localhost:8082/work/";
	// TODO S3-7-3-2 Zuul URL 추가
	public static final String URL = "http://localhost:8093/work/";

	// TODO S3-7-3-3 기존 RestTemplate 주석 처리
	/*
	@Autowired
	private RestTemplate restTemplate;
	*/
	// TODO S3-7-3-4 OAuth2RestTemplate 사용을 위한 추가
	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;

	@Autowired
	MemberRepository memberRepository;
	
	// work 마이크로서비스 정보 가져오기
	@HystrixCommand(commandKey = "getWorkInfo", fallbackMethod = "getWorkInfoFallback") // hystrix 폴백 선언
	@Override
	public String getWorkInfo(String workNum) {
		WorkVO workVO = new WorkVO();
		ResponseEntity<WorkVO> result = oAuth2RestTemplate.exchange // TODO S3-7-3-5 oAuth2RestTemplate로 대체
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
		ResponseEntity<WorkVO> result = oAuth2RestTemplate.exchange // TODO S3-7-3-6 oAuth2RestTemplate로 대체
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