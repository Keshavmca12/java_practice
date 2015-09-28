package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		System.out.println("login");
		return "sessionApp";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		System.out.println("signin");
		return "invalidSession";
	}
	
	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public String invalidSession() {
		System.out.println("invalidSession");
		return "invalidSession";
	}
}
