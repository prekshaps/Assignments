package com.example.demo.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Product;

public class ProductNotFoundTest {
	
	
	
	
	
	@Test
	public void testProduct() {
		Exception exception = assertThrows(ProductNotFoundException.class,()->{
			Product p = new Product();
			p.setId(3);
		}
		);
		assertEquals("Product not found",exception.getMessage());
	}
}
