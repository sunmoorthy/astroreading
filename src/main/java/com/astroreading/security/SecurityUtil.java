package com.astroreading.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.astroreading.model.User;
import com.opensymphony.xwork2.ActionContext;

public final class SecurityUtil {

	private SecurityUtil() {}

	public static final String SESSION_USER = "SESSION_USER";

	/**
	 * get the current user
	 * 
	 * @return
	 */
	public static User getCurrentUser() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		}
		if (auth.getPrincipal() instanceof CustomUserDetails) {
			return ((CustomUserDetails) auth.getPrincipal()).getUser();
		}
		return null;
	}

	/**
	 * check for a validated account
	 * 
	 * @return
	 */
	public static boolean isCurrentUserValidated() {
		final User user = SecurityUtil.getCurrentUser();
		if (user != null /* && (user.getDeactivationDate() == null || user.getDeactivationDate().compareTo(new Date()) > 0) */) {
			return true;
		}
		return false;
	}

	/**
	 * get the current user's username
	 * 
	 * @return
	 */
	public static String getCurrentUsername() {
		final User user = SecurityUtil.getCurrentUser();
		if (user == null) {
			return "astroreading";
		}
		return user.getEmail();
	}

	/**
	 * set the current user
	 * 
	 * @param user
	 */
	public static void setCurrentUser(final User user) {
		SecurityContextHolder.clearContext();
		final CustomUserDetails principal = new CustomUserDetails();
		principal.setUser(user);
		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken(principal, user.getPassword()));
	}

	/**
	 * clear the current user
	 */
	public static void clearCurrentUser() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * get the user from session
	 * 
	 * @param session
	 * @return
	 */
	public static User getSessionUser(final HttpSession session) {
		if (session != null) {
			return (User) session.getAttribute(SecurityUtil.SESSION_USER);
		}
		return null;
	}

	/**
	 * set the user in session and the security context
	 * 
	 * @param session
	 * @param user
	 */
	public static void setSessionUser(final HttpSession session, final User user) {
		if (session == null) {
			throw new IllegalArgumentException("Session is null");
		}
		session.setAttribute(SecurityUtil.SESSION_USER, user);
		SecurityUtil.setCurrentUser(user);
	}

	public static void clearSession() {
		final HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(
			StrutsStatics.HTTP_REQUEST);

		if (request.getSession() != null) {
			request.getSession().invalidate();
		}

		SecurityUtil.clearCurrentUser();
	}

}
