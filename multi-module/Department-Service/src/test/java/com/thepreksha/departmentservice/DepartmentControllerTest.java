package com.thepreksha.departmentservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thepreksha.departmentservice.Controller.DepartmentController;
import com.thepreksha.departmentservice.Entity.Department;
import com.thepreksha.departmentservice.service.DepartmentService;



@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	
	@MockBean
	private DepartmentService departmentService;
	
	//@Autowired
	//private WebApplicationContext webApplicationContext;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Test
	void shouldCreateMockMvc() {
		assertNotNull(mockMvc);
	}
	
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void saveDepartmentTest() throws Exception {
		Department department = new Department(1L,"HR","Bangalore","999");
		when(departmentService.save(ArgumentMatchers.any())).thenReturn(department);
        String json = mapper.writeValueAsString(department);
        mockMvc.perform(post("/departments/").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
               .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
               .andExpect(jsonPath("$.id",Matchers.equalTo(1L)))
               .andExpect(jsonPath("$.departmentName",Matchers.equalTo("HR")))
               .andExpect(jsonPath("$.departmentAddress",Matchers.equalTo("Bangalore")))
               .andExpect(jsonPath("$.departmentCode",Matchers.equalTo("999")));
	}
	
	@Test
	public void getDepartmentTest() throws Exception {
		Department department = new Department();
		department.setId(1L);
		department.setDepartmentName("HR");
		department.setDepartmentAddress("Bangalore");
		department.setDepartmentCode("999");
	    when(departmentService.findDepartmentById(1L)).thenReturn(department);        
	    String json = mapper.writeValueAsString(department);
        mockMvc.perform(get("/departments/{id}",1L)).andExpect(status().isOk()).andExpect(jsonPath("$",Matchers.hasSize(1)))
         .andExpect(jsonPath("$[0].id",Matchers.equalTo(1L)))
         .andExpect(jsonPath("$[0].departmentName",Matchers.equalTo("HR")))
        .andExpect(jsonPath("$[0].departmentAddress",Matchers.equalTo("Bangalore")))
        .andExpect(jsonPath("$[0].departmentCode",Matchers.equalTo("999")));
        	}
	
	
	
               
        
		
	}
	


