package com.example.demo.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Product;

/**
 * Class that check the Exception
 * 
 * @author P7112764
 *
 */
public class ProductAlreadyExistsTest {
	/**
	 * Testcase to check wheather ProductAlreadyExistsException is working
	 */
	@Test
	public void testProduct2() {
		Exception exception = assertThrows(ProductAlreadyExistsException.class, () -> {
			Product p = new Product();
			p.setId(1);
		});
		assertEquals("Product Already exits", exception.getMessage());
	}

}
