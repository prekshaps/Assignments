package com.thepreksha.departmentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.thepreksha.departmentservice.Entity.Department;
import com.thepreksha.departmentservice.Repository.DepartmentRepository;
import com.thepreksha.departmentservice.service.DepartmentService;


@SpringBootTest
public class departmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	
	
	@Test
	public void saveTest() {
		Department department = new Department(1L,"HR","Bangalore","456");
		when(departmentRepository.save(department)).thenReturn(department);
		assertEquals(department,departmentService.save(department));
		
		
	}
	
	@Test
	public void testgetById() {
		Long id = new Long(1L);
		Department department = new Department(id,"HR","Bangalore","456");
		when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
		assertEquals(department.getId(),departmentService.findDepartmentById(id));
		
			
		
		}

}
