package com.dao;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DiscriminatorOptions;

@Entity(/*name = "ForeignKeyAssoSalaryEntity"*/)

//@DiscriminatorOptions(force=true)
@Table(name="salary"/*,uniqueConstraints = {
		@UniqueConstraint(columnNames = "id")}*/)
public class Salary   /* implements Serializable */{
	//private static final long serialVersionUID = -6790693372846798580L;
	
    
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id"/*, unique = true, nullable = false*/)
	private int id;
	
	@Column(name="month"/*, unique = false, nullable = false*/)
	private String month;
	@Id
	@Column(name="leave_"/*, unique = false, nullable = false*/)
	private int leave_;
	
//	@Column(name="salaryDeduction"/*, unique = false, nullable = false*/)
//	private int salaryDeduction;

	//@ManyToOne
    //private Employee emp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getLeave_() {
		return leave_;
	}
	public void setLeave_(int leave_) {
		this.leave_ = leave_;
	}
/*	public int getSalaryDeduction() {
		return salaryDeduction;
	}
	public void setSalaryDeduction(int salaryDeduction) {
		this.salaryDeduction = salaryDeduction;
	}*/
}
