package com.thepreksha.EmployeeService.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thepreksha.EmployeeService.dto.Department;
import com.thepreksha.EmployeeService.dto.EmployeeResponse;
import com.thepreksha.EmployeeService.entity.Employee;
import com.thepreksha.EmployeeService.repository.EmployeeServiceRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeServiceRepository employeeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public EmployeeResponse findEmployeeById(Long id) {
		Employee employee = employeeRepository.findEmployeeById(id);
		Department department =  restTemplate.getForObject("http://localhost:8002/departments/"+ employee.getDepartmentId(), Department.class);

		EmployeeResponse response = new EmployeeResponse();
		response.setEmployee(employee);
		response.setDepartment(department);
		return response;
		
	}
}