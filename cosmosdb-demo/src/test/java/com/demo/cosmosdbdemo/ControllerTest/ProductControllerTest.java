package com.demo.cosmosdbdemo.ControllerTest;

import static org.mockito.Mockito.doNothing;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.cosmosdbdemo.controller.ProductController;
import com.demo.cosmosdbdemo.model.Product;
import com.demo.cosmosdbdemo.service.ProductService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@MockBean
	private ProductService productService;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		RestAssuredMockMvc.mockMvc(mockMvc);
		Product product = new Product("1", "book", 300, "books");
	}

	@Test
	public void getProductByName() {
		Mockito.when(productService.findProductByName("book"))
				.thenReturn(List.of(new Product("1", "book", 300, "books")));
		RestAssuredMockMvc.when().get("/products/productname/{name}").then().statusCode(200)
				.body("$.size()", Matchers.equalTo(1)).body("[0].productId", Matchers.equalTo("1"))
				.body("[0].productName", Matchers.equalTo("book")).body("[0].price", Matchers.equalTo(300))
				.body("[0].productCategory", Matchers.equalTo("books"));

	}

	@Test
	public void addProductTest() {
		RestAssuredMockMvc.given().contentType("application/json").body(
				"{\"productId\":\"30\",\"productName\":\"apple\",\"price\":\"155\",\"productCategory\":\"fruites\"}")
				.when().post("/products").then().statusCode(201);
	}

	@Test
	public void delete() throws Exception {
		((ResultActions) ((MockMvcRequestSpecification) this.mockMvc.perform(
				MockMvcRequestBuilders.delete("/products/1/category/books").contentType(MediaType.APPLICATION_JSON)))
						.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
