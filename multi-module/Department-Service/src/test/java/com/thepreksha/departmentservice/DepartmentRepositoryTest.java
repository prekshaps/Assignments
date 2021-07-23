package com.thepreksha.departmentservice;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.thepreksha.departmentservice.Entity.Department;
import com.thepreksha.departmentservice.Repository.DepartmentRepository;


@DataJpaTest
public class DepartmentRepositoryTest {
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	
	
	@Test
	public void testDepartment() {
		Department department = new Department();
		department.setId(1L);
		department.setDepartmentName("HR");
		department.setDepartmentAddress("Bangalore");
		department.setDepartmentCode("999");
		departmentRepository.save(department);
		Assertions.assertThat(department.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testDepartmentId() {
		
		
		Department department = departmentRepository.findById(1L).get();
		Assertions.assertThat(department.getId()).isEqualTo(1L);
				
	}



}
