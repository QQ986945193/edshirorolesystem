package com.david.edshriorolesystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录的controller
 * 
 * @author david
 */

@Controller
public class LoginController {
	/**
	 * get请求方式，转发到登录的login.jsp
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUi() {
		return "../../login";
	}
	/**
	 * Post 方式，登录的功能请求
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(){
		return "login";
	 }

}
