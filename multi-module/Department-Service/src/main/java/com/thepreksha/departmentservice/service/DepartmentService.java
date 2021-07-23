package com.thepreksha.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thepreksha.departmentservice.Entity.Department;
import com.thepreksha.departmentservice.Repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(long i) {
		return departmentRepository.findDepartmentById(i);
	}
	
}