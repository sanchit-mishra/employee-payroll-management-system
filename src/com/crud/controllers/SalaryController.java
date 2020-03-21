package com.crud.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Employee;
import com.dao.Salary;
import com.db.HibernateDatabaseConnection;

@Controller
public class SalaryController {
	@RequestMapping("/manage_salary")
	public String getManageSalaryForm() {
		return "view/salary_add.jsp";
	}

	@RequestMapping(value="manage_salary_action",method = RequestMethod.POST)
	public void addLeaveData(HttpServletResponse res,
			@ModelAttribute("salary") Salary sal) throws IOException{
	// System.out.println(sal.getMonth());
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(sal);
		
		t.commit();
		res.sendRedirect("dashboard"); 
	}
	
	
	
	@RequestMapping("/manage")
	public String getLeaveData(HttpServletResponse res,Model m,
			@RequestParam("id") int id) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Query query2= session.createQuery("FROM Salary WHERE id = :id");
		query2.setParameter("id",id);
		
		
		List sal_list = ((org.hibernate.query.Query) query2).list();
		m.addAttribute("salary_list",sal_list);
		
		return "view/manageSalary.jsp";
	}
	
}