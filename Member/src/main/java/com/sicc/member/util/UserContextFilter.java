package com.sicc.member.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 유저 컨텍스트 필터
 * @author Woongs
 */
// TODO S3-6-6-1 유저 컨텍스트 필터
public class UserContextFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);	// log
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(">>> doFilter() is called");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		UserContextHolder.getContext().setSn(httpServletRequest.getHeader(UserContext.SN));
		
		logger.debug("UserContextFilter Correlation Id: {}", UserContextHolder.getContext().getCorrelationId());
		
		filterChain.doFilter(httpServletRequest, servletResponse);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
}