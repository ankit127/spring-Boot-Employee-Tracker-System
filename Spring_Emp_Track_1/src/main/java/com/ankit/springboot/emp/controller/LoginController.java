package com.ankit.springboot.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		logger.info("Login Page Called");
		return "fancy-login";
		
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		logger.info("Access Denied Called");
		return "access-denied";
		
	}
	
	
}