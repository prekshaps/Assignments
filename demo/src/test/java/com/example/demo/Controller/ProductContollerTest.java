package com.example.demo.Controller;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class to test the Endpoints
 * 
 * @author P7112764
 *
 */
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ProductService productService;
	private Product product;
	private List<Product> productList;

	@InjectMocks
	private ProductController productController;

	/**
	 * method which executes before each testcase
	 */
	@BeforeEach
	public void setup() {
		product = new Product(1, "ball", 670);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	/**
	 * method that executes after each testcase
	 */
	@AfterEach
	void tearDown() {
		product = null;
	}

	/**
	 * testcase to check the endpoint to save the product
	 * 
	 * @throws Exception
	 */
	@Test
	public void PostMappingOfProduct() throws Exception {
		when(productService.addProduct(any())).thenReturn(product);
		mockMvc.perform(post("/api/v1/product").contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
				.andExpect(status().isCreated());
		verify(productService, times(1)).addProduct(any());
	}

	/**
	 * testcase to check the endpoint to get products
	 * 
	 * @throws Exception
	 */
	@Test
	public void GetMappingOfAllProduct() throws Exception {
		when(productService.getAllProducts()).thenReturn(productList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(product))).andDo(MockMvcResultHandlers.print());
		verify(productService).getAllProducts();
		verify(productService, times(1)).getAllProducts();
	}

	/**
	 * testcase to check endpoint that return the product based on id
	 * 
	 * @throws Exception
	 */
	@Test
	public void GetMappingOfProductShouldReturnRespectiveProducct() throws Exception {
		when(productService.getProductByid(product.getId())).thenReturn(product);
		mockMvc.perform(get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * testcase to check the enpoint to delete the product
	 * 
	 * @throws Exception
	 */
	@Test
	public void DeleteMappingUrlAndIdThenShouldReturnDeletedProduct() throws Exception {
		when(productService.deleteProductById(product.getId())).thenReturn(product);
		mockMvc.perform(
				delete("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(product)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 
	 * @Test public void givenNotFound_whenGetSpecificException_thenNotFoundCode()
	 * throws Exception{ String exceptionParam = "Not_found";
	 * mockMvc.perform(get("/exception/{exception_id}",exceptionParam)
	 * .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isNotFound())
	 * .andExpect(result -> assertTrue(result.getResolvedException() instanceof
	 * ResourceNotFoundException)) .andExpect(result ->
	 * assertEquals("resource Not found",result.getResolvedException().getMessage())
	 * ); }
	 * 
	 * @Test public void givenBadArguments_whenGetSpecificException_thenBadRequest()
	 * throws Exception{ String exceptionParam = "bad_arguments";
	 * mockMvc.perform(get("/exception/{exception_id}",exceptionParam)
	 * .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isBadRequest())
	 * .andExpect(result -> assertTrue(result.getResolvedException() instanceof
	 * BadArgumentException)) .andExpect(result ->
	 * assertEquals("bad argumnent",result.getResolvedException().getMessage())); }
	 * 
	 * @Test public void givenOther_whenGetSpecifiException_thennternalServerError()
	 * throws Exception{ String exceptionParam = "dummy";
	 * mockMvc.perform(get("/exception/{exception_id}",exceptionParam)
	 * .contentType(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isInternalServerError()) .andExpect(result ->
	 * assertTrue(result.getResolvedException() instanceof InternalException))
	 * .andExpect(result ->
	 * assertEquals("dummy",result.getResolvedException().getMessage())); }
	 */

	/*
	 * 
	 * @Test public void whenGetException_thenInternalServerError() throws
	 * Exception{ Assertions.assertThrows(Exception.class, new Executable(){
	 * 
	 * @Override public void execute() throws Throwable { // TODO Auto-generated
	 * method stub mockMvc.perform(get("/exception/throw")
	 * .contentType(MediaType.APPLICATION_JSON)); }
	 * 
	 * 
	 * }); }
	 */
}