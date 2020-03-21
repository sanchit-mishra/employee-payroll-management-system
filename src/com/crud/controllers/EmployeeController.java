package com.crud.controllers;

import java.io.IOException;


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
public class EmployeeController {
	@RequestMapping("/add_employee")
	public String getAddEmployeeForm() {
		return "view/employee_addform.jsp";
	}
	
	/*Adding Employee Details in database through hibernate */
	@RequestMapping(value="add_employee_action",method = RequestMethod.POST)
	public void addEmployee(HttpServletResponse res,
			@ModelAttribute("employee") Employee emp) throws IOException{
	 //System.out.println();
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(emp);
		
		t.commit();
		res.sendRedirect("dashboard"); 
	}
	
	@RequestMapping(value="edit_employee_action",method = RequestMethod.POST)
	public void editEmployee(HttpServletResponse res,
			@ModelAttribute("employee") Employee emp) throws IOException{
	 //System.out.println();
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		
		Transaction t=session.beginTransaction();

		Query query= session.createQuery("update Employee set name = :name,age = :age, designation = :designation, salary = :salary WHERE id = :id");
		
		query.setParameter("name", emp.getName());
		query.setParameter("id", emp.getId());
		query.setParameter("age", emp.getAge());
		query.setParameter("designation", emp.getDesignation());
		query.setParameter("salary", emp.getSalary());
		
		int result = query.executeUpdate();
		
		//session.saveOrUpdate(emp);
		
		t.commit();
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/delete")
	public void deleteUser(HttpServletResponse res,@RequestParam("id") int id) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		Employee emp_del= new Employee();
		emp_del.setId(id);
		
		session.delete(emp_del);
		
		t.commit();
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/edit")
	public String getEditForm(HttpServletResponse res,Model m,
			@RequestParam("id") int id) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Query query2= session.createQuery("FROM Employee WHERE id = :id");
		query2.setParameter("id",id);
		
		Employee emp = (Employee)query2.getSingleResult();
		m.addAttribute("employee",emp);
		
		return "view/edit_employee.jsp";
	}
}
