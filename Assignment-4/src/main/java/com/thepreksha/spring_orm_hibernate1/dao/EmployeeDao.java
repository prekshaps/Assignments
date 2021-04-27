package com.thepreksha.spring_orm_hibernate1.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.thepreksha.spring_orm_hibernate1.entities.Employee;

public class EmployeeDao {

	
	@Override
	public String toString() {
		return "EmployeeDao [hibernateTemplate=" + hibernateTemplate + "]";
	}

	private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
