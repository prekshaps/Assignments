package com.example.departmentservices.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentservices.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findDepartmentById(Long departmentId);

}