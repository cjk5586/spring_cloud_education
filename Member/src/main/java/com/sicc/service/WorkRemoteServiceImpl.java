package com.sicc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkRemoteServiceImpl implements WorkRemoteService {

	private static final String URL = "http://localhost:8082/works/"; // ±âº» URL
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String getWorkInfo(String workId) {
		return restTemplate.getForObject(URL+workId, String.class);
	}
}
