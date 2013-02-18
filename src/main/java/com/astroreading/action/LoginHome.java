package com.astroreading.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.astroreading.model.User;
import com.astroreading.service.UserService;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "success", location = "/index.jsp"),
	@Result(name = "loginForm", location = "/pages/login.jsp"),
	@Result(name = "loginSuccess", location = "/pages/user/userHome.jsp")
})
public class LoginHome extends ActionSupport {

	@Autowired
	private UserService userService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private User user;

	@Action("")
	public String execute() {
		return SUCCESS;
	}

	@Action("login")
	public String login() {
		if (Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)) {
			return "loginForm";
		}
		user = userService.findUserByLogin(email, password);
		if (user != null) {
			return "loginSuccess";
		}
		return SUCCESS;
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
