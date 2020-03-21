package com.dao;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DiscriminatorOptions;

@Entity
//@DiscriminatorOptions(force=true)
@Table(name = "employee")
public class Employee{
	//private static final long serialVersionUID = -1798070786993154676L;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id" /*unique = true, nullable = false*/)
	private int id;
	
	@Column(name = "name"/*, unique = false, nullable = false*/)
	private String name;
	
	@Column(name = "age"/*, unique = false, nullable = false*/)
	private int age;
	
	@Column(name = "designation"/*, unique = false, nullable = false*/)
	private String designation;
	
	@Column(name = "salary"/*, unique = false, nullable = false*/)
	private int salary;
	
	 //@OneToMany(cascade=CascadeType.ALL)
	   // @JoinColumn(name="id")
	   // private Set<Salary> sal;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
    public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
