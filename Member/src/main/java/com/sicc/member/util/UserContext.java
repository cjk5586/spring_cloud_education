package com.sicc.member.util;

import org.springframework.stereotype.Component;

/**
 * 유저 컨텍스트
 * @author Woongs
 */
// TODO S3-6-4-1 유저 컨텍스트
@Component
public class UserContext {
	// 초기값 필요치 않음
	public static final String CORRELATION_ID = "static-correlation-id";
	public static final String AUTH_TOKEN = "static-auth-token";
	public static final String USER_ID = "static-user-id";
	public static final String SN = "static-sn";

	private String correlationId; 
	private String authToken;
	private String userId;
	private String sn;

	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
}