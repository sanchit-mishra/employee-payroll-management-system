package com.crud.controllers;

import java.io.IOException;


import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
/*Admin Login*/	
	@RequestMapping("/login")
	public String getLoginForm() {
		return "view/loginForm.jsp";
	}
	@RequestMapping(value="/login_action",method=RequestMethod.POST)
	public void checkCreds(@RequestParam("username")String unm,@RequestParam("password") String pwd,HttpServletRequest req,HttpServletResponse res) throws IOException {
	    //System.out.println(unm +"&&"+pwd);
		
		if(unm.equals("admin") && pwd.equals("@dmin")) {
			req.getSession().setAttribute("username", unm);
			res.sendRedirect("dashboard");
	}else {
		res.sendRedirect("login");
	}
	
   }
/*Admin Logout*/
	@RequestMapping("/logout")
	public void logoutUser(HttpServletRequest req,HttpServletResponse res)throws IOException {
		req.getSession().invalidate();
		res.sendRedirect("view/loginForm.jsp");
		
	}
}
