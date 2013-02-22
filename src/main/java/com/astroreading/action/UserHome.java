package com.astroreading.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.astroreading.model.User;
import com.astroreading.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/user")
@Results({
	@Result(name = "success", location = "/pages/user/userHome.jsp"),
})
@InterceptorRefs({
	@InterceptorRef("secureStack"),
})
public class UserHome extends ActionSupport {

	@Autowired
	private UserService userService;

	private User user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action("home")
	public String execute() {
		return SUCCESS;
	}

	

	

}
