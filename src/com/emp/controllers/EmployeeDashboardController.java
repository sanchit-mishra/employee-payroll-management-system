package com.emp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Employee;
import com.dao.Salary;
import com.dao.Empauth;
import com.db.HibernateDatabaseConnection;

@Controller
public class EmployeeDashboardController {
	/* Employee Salary Deduction based on the number of leaves taken */

	@RequestMapping("/dashboardemp")
	public String showSalary(Model m,HttpServletRequest req,HttpServletResponse res) throws IOException {
		if(req.getSession().getAttribute("username")==null){
			res.sendRedirect("emplogin");
		}
		String un=(String)req.getSession().getAttribute("username");
		String pd=(String)req.getSession().getAttribute("password");
		int salaryid=Integer.parseInt(pd);
		//   Integer sid = (Integer)req.getAttribute("password");
		//   int salaryid =  sid.intValue();
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Employee where name =:un");


		Query query3 = session.createQuery("  FROM Salary where id =:salaryid");  //hibernate query(hql) to fetch data from salary table
		Query query4 = session.createQuery("  FROM Employee where name=:un");     
		Query query5 = session.createQuery("select month FROM Salary where id =:salaryid");  // hql to retrieve month from salary table
		query2.setParameter("un",un);
		query3.setParameter("salaryid", salaryid);
		query4.setParameter("un",un);
		query5.setParameter("salaryid",salaryid);

		List emps = ((org.hibernate.query.Query) query2).list();
		List desal = ((org.hibernate.query.Query) query3).list();
		List sal = ((org.hibernate.query.Query) query4).list();
		List months= ((org.hibernate.query.Query) query5).list();
		System.out.println(months);
		System.out.println(desal);   
		Iterator itr=desal.iterator();
		Iterator itr1=sal.iterator();

		Employee e = new Employee();
		while(itr1.hasNext()) {
			
			e=(Employee)itr1.next();
			
		}
		System.out.println(e.getSalary());
		Salary s = new Salary();
		
		int base_salary = e.getSalary();//to get base salary
		int temp = base_salary;
		
		System.out.println(temp);
		List<Integer> al = new ArrayList<Integer>();
		/* Salary Deduction Based on number of leaves*/
		while(itr.hasNext())
		{   s= (Salary) itr.next();
		
		int no_leave =s.getLeave_();
		temp = temp - (100*no_leave);
		al.add(temp);
		temp=base_salary;
		}
		//System.out.println(al);
		m.addAttribute("employee_list",emps); //contains employee details
		m.addAttribute("salary_list",al);     //contains salary details
		m.addAttribute("month_list", months); //contains month details for corresponding leave
		//System.out.println(emps);

		return "view/empDashboard.jsp"; //returning above list to employee dashboard page.
	}

}
