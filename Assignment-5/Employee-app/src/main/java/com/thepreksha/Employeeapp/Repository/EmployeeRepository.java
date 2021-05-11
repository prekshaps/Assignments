package com.thepreksha.Employeeapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thepreksha.Employeeapp.service.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}