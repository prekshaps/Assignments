package com.thepreksha.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thepreksha.EmployeeService.Controller.EmployeeController;
import com.thepreksha.EmployeeService.dto.EmployeeResponse;
import com.thepreksha.EmployeeService.entity.Employee;
import com.thepreksha.EmployeeService.service.EmployeeService;





@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@MockBean
	EmployeeService employeeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldCreateMockMvc() {
		assertNotNull(mockMvc);
	}
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void saveEmployeeTest() throws Exception {
		Employee employee = new Employee(1L,"Jhon","tom","jhon@gamil.com",1L);
		when(employeeService.saveEmployee(ArgumentMatchers.any())).thenReturn(employee);
        String json = mapper.writeValueAsString(employee);
        mockMvc.perform(post("/employees/").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
               .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
               .andExpect(jsonPath("$.id",Matchers.equalTo(1L)))
               .andExpect(jsonPath("$.firstName",Matchers.equalTo("Jhon")))
               .andExpect(jsonPath("$.lastName",Matchers.equalTo("tom")))
               .andExpect(jsonPath("$.email",Matchers.equalTo("jhon@gmail.com")))
               .andExpect(jsonPath("$.departmentId",Matchers.equalTo(1L)));
	}
	/*
	@Test
	public void getEmployeeTest() throws Exception {
		Employee employee = new Employee(1L,"Jhon","tom","jhon@gamil.com",1L);
		when(employeeService.findEmployeeById(1L)).thenReturn(isNullable(null));        
	    String json = mapper.writeValueAsString(department);
        mockMvc.perform(get("/departments/{id}",1L)).andExpect(status().isOk()).andExpect(jsonPath("$",Matchers.hasSize(1)))
         .andExpect(jsonPath("$[0].id",Matchers.equalTo(1L)))
         .andExpect(jsonPath("$[0].departmentName",Matchers.equalTo("HR")))
        .andExpect(jsonPath("$[0].departmentAddress",Matchers.equalTo("Bangalore")))
        .andExpect(jsonPath("$[0].departmentCode",Matchers.equalTo("999")));
        	}*/
	

}
