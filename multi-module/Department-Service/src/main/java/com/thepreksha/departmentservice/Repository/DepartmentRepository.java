package com.thepreksha.departmentservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thepreksha.departmentservice.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findDepartmentById(Long departmentId);

	

}