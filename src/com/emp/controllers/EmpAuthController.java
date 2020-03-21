package com.emp.controllers;

import java.io.IOException;

import java.util.Iterator;
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

import com.dao.Empauth;
import com.dao.Employee;
import com.dao.Salary;
import com.db.HibernateDatabaseConnection;


@Controller
public class EmpAuthController {

	@RequestMapping("/emplogin")
	public String getLoginForm() {
		return "view/employeeLogin.jsp";
	}
	
/*Registration of Employee Login Credentials*/
	
	@RequestMapping("/register")
	public String registerUserList(Model m,HttpServletRequest req,HttpServletResponse res)throws IOException {
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Empauth");
		List remps = ((org.hibernate.query.Query) query2).list();
		
		
		m.addAttribute("register_list",remps);
		//System.out.println(emps);

		return "view/registerEmp.jsp";
		

	}
	
	@RequestMapping("/register_employee")
	public String getAddForm() {
		return "view/registerAddForm.jsp";
	}
	
	@RequestMapping(value="register_employee_action",method= RequestMethod.POST)
		public void regiterUser(HttpServletResponse res,@ModelAttribute("register") Empauth e1)throws IOException {
		 Session session = null;
		 session = HibernateDatabaseConnection.getSessionFactory().openSession();
		 
		 Transaction t = session.beginTransaction();
		 
		 session.save(e1);
		 t.commit();
		 res.sendRedirect("register");
		}
	
/*Deleting Login Credentials*/	
	@RequestMapping("/del")
	public void deleteUser(HttpServletResponse res,@RequestParam("id") int id) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		Empauth e1 = new Empauth();
		e1.setId(id);
		session.delete(e1);
		
		t.commit();
		res.sendRedirect("register");
	}
	
	
	
	
	@RequestMapping(value="/emp_login",method=RequestMethod.POST)
	public void checkCreds(@RequestParam("username")String unm,@RequestParam("password") String pwd,HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println(unm +"&&"+pwd);

		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();

		Query query2= session.createQuery("FROM Empauth");


		Empauth e1=new Empauth();
		List emp_list = ((org.hibernate.query.Query) query2).list();
		Iterator itr=emp_list.iterator();

		while(itr.hasNext()) {

			e1=(Empauth)itr.next();
			String u1=e1.getUsername();
			String pass=e1.getPassword();
			int pid=e1.getId();  //Getting primitive id
			String p1= String.valueOf(pid); //Type casting it into String for authentication
			if(unm.equals(u1) && pwd.equals(pass)) {
				req.getSession().setAttribute("username", unm);
				req.getSession().setAttribute("password", p1);

				res.sendRedirect("dashboardemp");
				break;

			}else {
				//res.sendRedirect("emplogin");
			}
		}
	}
	@RequestMapping("/logout2")
	public void logoutUser(HttpServletRequest req,HttpServletResponse res)throws IOException {
		req.getSession().invalidate();
		res.sendRedirect("view/employeeLogin.jsp");

	}
}
