package com.examples.demoproduct.Controller;






import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.examples.demoproduct.model.Product;
import com.examples.demoproduct.Service.ProductService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;


@WebMvcTest(ProductController.class)
public class ApiTesting {
	
	@MockBean
	private ProductService productService;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}
	
	@Test
	public void getAllProductTest() {
		Mockito.when(productService.getAllProducts()).thenReturn(List.of(new Product(1,"book",300)));
		RestAssuredMockMvc
		.when()
		.get("api/data/products")
		.then()
		.statusCode(200)
		.body("$.size()", Matchers.equalTo(1))
		.body("[0].id", Matchers.equalTo(1))
		.body("[0].name", Matchers.equalTo("book"))
		.body("[0].price", Matchers.equalTo("300"));
		
	}
	
	@Test
	public void addProductTest() {
		RestAssuredMockMvc
		.given()
		.contentType("application/json")
		.body("{\"id\":\"30\",\"name\":\"apple\",\"price\":\"155\"}")
		.when()
		.post("api/data/product")
		.then()
		.statusCode(201);
	}
	
	
}
	
		
	

