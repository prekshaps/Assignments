package com.thepreksha.EmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thepreksha.EmployeeService.entity.Employee;



@Repository
public interface EmployeeServiceRepository extends JpaRepository<Employee, Long>{

	Employee findEmployeeById(Long id);
	
}