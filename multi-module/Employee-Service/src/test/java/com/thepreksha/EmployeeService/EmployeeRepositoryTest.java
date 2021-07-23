package com.thepreksha.EmployeeService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thepreksha.EmployeeService.entity.Employee;
import com.thepreksha.EmployeeService.repository.EmployeeServiceRepository;




@DataJpaTest
public class EmployeeRepositoryTest {
	
	@Autowired 
	private EmployeeServiceRepository repo;
	
	
	
	@Test
	public void testDepartment() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("Jhon");
		employee.setLastName("tom");
		employee.setEmail("jhon@gmail.com");
		employee.setDepartmentId(1L);
		repo.save(employee);
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
		}
	
	@Test
	public void testEmployeeById() {
	Employee employee = repo.findById(1L).get();
	Assertions.assertThat(employee.getId()).isEqualTo(1L);

}
}