package com.thepreksha.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.thepreksha.EmployeeService.entity.Employee;
import com.thepreksha.EmployeeService.repository.EmployeeServiceRepository;
import com.thepreksha.EmployeeService.service.EmployeeService;


@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeServiceRepository employeeRepository;
	
	
	
	@Test
	public void saveTest() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("jhon");
		employee.setLastName("tom");
		employee.setEmail("jhon@gmail.com");
		employee.setDepartmentId(1L);
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.saveEmployee(employee));
		
}
	
}
