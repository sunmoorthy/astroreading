package com.astroreading.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.astroreading.model.Country;
import com.astroreading.model.User;
import com.astroreading.security.SecurityUtil;
import com.astroreading.service.UserService;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/auth")
@Results({
	@Result(name = "success", location = "/index.jsp"),
	@Result(name = "loginForm", location = "/pages/login.jsp"),
	@Result(name = "loginSuccess", location = "/pages/user/userHome.jsp"),
	@Result(name = "register", location = "/pages/login.jsp"),
	@Result(name = "registerForm", location = "/pages/user/register.jsp"),
	@Result(name = "logoutSuccess", location = "/index.jsp"),
})
public class LoginHome extends BaseHome {

	@Autowired
	private UserService userService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private User user;
	

	@Action("home")
	public String execute() {
		return SUCCESS;
	}
	
	

	@Action("login")
	public String login() {
		final HttpSession session = ServletActionContext.getRequest().getSession(true);
		if (Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)) {
			return "loginForm";
		}
		user = userService.findUserByLogin(email, password);
		if (user != null) {
			SecurityUtil.setSessionUser(session, user);
			return "loginSuccess";
		}
		return SUCCESS;
	}
	
	@Action("logout")
	public String logout() {
		SecurityUtil.clearSession();
		return "logoutSuccess";
	}
	
	
	
	@Action("register")
	public String register() {
		if (user == null) {
			return "registerForm";
		}
		userService.register(user);
		return "register";
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	

}
