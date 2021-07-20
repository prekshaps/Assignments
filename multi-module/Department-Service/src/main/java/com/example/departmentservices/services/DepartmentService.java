package com.example.departmentservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservices.Entity.Department;
import com.example.departmentservices.Respository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		return departmentRepository.findDepartmentById(departmentId);
	}
	
}