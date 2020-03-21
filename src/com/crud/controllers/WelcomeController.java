package com.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	public WelcomeController() {
		System.out.println("Testing Sanchit Work");
	}
	
	@RequestMapping("/welcome")
	public String welcomePage() {
		return "index.jsp";
	}

}
