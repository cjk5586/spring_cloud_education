package com.sicc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sicc.member.vo.WorkVO;

/**
 * Work 마이크로서비스 통신을 위한 구현
 * @author Woongs
 */
// TODO S1-2-3-1 Work 마이크로서비스 통신을 위한 구현 생성
@Service	// TODO S1-2-3-2 서비스로서 선언
public class WorkRemoteServiceImpl implements WorkRemoteService {	// TODO S1-2-3-3 구현할 인터페이스 설정
	public static final String URL = "http://localhost:8082/work/";	// TODO S1-2-3-4 이동할 URL 선언
	
	// TODO S1-2-3-5 restTemplate 이용
	@Autowired
	private RestTemplate restTemplate;

	// TODO S1-2-3-6 Work 마이크로서비스 정보 조회 하는 함수
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
}