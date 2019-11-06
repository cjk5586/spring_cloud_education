package com.sicc.member.util;

import org.springframework.util.Assert;

/**
 * 유저 컨텍스트 홀더
 * @author Woongs
 */
// TODO S3-6-5-1 유저컨텍스트 Holder
public class UserContextHolder {
	private static ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();
	// get
	public static final UserContext getContext() {
		System.out.println(">>> getContext() is called!");
		
		UserContext context = userContext.get(); 
		
		if(context == null) {
			context = createEmptyContext();
			userContext.set(context);
		}
		return userContext.get();
	}
	// set
	public static final void setContext(UserContext context) {
		System.out.println(">>> setContext() is called!");
		
		Assert.notNull(context, "Only non-null UserContext instaces are permitted.");
		userContext.set(context);
	}	
	// create
	private static final UserContext createEmptyContext() {
		System.out.println(">>> createEmptyContext() is called!");
		
		return new UserContext();
	}
}
