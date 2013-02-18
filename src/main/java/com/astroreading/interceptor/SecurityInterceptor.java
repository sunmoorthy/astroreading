package com.astroreading.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.astroreading.model.User;
import com.astroreading.security.SecurityUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8360396529172442718L;

	public static final String SESSION_STORED_REQUEST_PATH = "SESSION_STORED_REQUEST_PATH";
	public static final String SESSION_STORED_REQUEST_PARAM = "SESSION_STORED_REQUEST_PARAM";

	/**
	 * check for session and establish security context
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String intercept(final ActionInvocation invocation) throws Exception {
		// check if session user exists
		final HttpSession session = ServletActionContext.getRequest().getSession(true);
		final User user = SecurityUtil.getSessionUser(session);
		// save the request params for redirect after successful authentication
		if (user == null) {
			return "/auth/home";
		} else {
			SecurityUtil.setCurrentUser(user);
		}
		try {
			return invocation.invoke();
		} finally {
			SecurityUtil.clearCurrentUser();
		}
	}
}
