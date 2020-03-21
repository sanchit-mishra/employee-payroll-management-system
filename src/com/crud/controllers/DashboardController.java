package com.crud.controllers;

import java.io.IOException;


import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.Employee;
import com.db.HibernateDatabaseConnection;

@Controller
public class DashboardController {
	/*Admin Dashboard Logic*/
	@RequestMapping("/dashboard")
	public String loadDashboard(Model m,HttpServletRequest req,HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("username")==null){
			res.sendRedirect("login");
		}
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Employee");
		List emps = ((org.hibernate.query.Query) query2).list();
		
		
		m.addAttribute("employee_list",emps);//List of employee details
		//System.out.println(emps);

		return "view/dashboard.jsp";
	}
	
}
