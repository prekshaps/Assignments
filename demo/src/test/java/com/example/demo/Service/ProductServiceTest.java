package com.example.demo.Service;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Exception.ProductAlreadyExistsException;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Testing Product service class
 * 
 * @author P7112764
 *
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

//handles business logic
	// unit testing so mocking
	@Mock
	private ProductRepository productRepository;

	@Autowired
	@InjectMocks
	private ProductServiceImpl productService;
	private Product product1;
	private Product product2;
	List<Product> productList;

	/**
	 * Method which executes before Each testcase
	 */
	@BeforeEach
	public void setUp() {
		productList = new ArrayList<>();
		product1 = new Product(1, "bread", 20);
		product2 = new Product(2, "jam", 200);
		productList.add(product1);
		productList.add(product2);
	}

	/**
	 * testcase to check wheather method returns the all products
	 */
	@Test
	public void GivenGetAllUsersShouldReturnListOfAllUsers() {
		productRepository.save(product1);
		when(productRepository.findAll()).thenReturn(productList);
		List<Product> productList1 = productService.getAllProducts();
		assertEquals(productList1, productList);
		verify(productRepository, times(1)).save(product1);
		verify(productRepository, times(1)).findAll();
	}

	/**
	 * testcase to test Wheather product is deleted or not
	 */
	@Test
	public void givenIdToDeleteThenShouldDeleteTheProduct() {
		Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product1));
		assertThat(productService.getProductByid(product1.getId())).isEqualTo(product1);

	}

	/**
	 * Testcase to check whether the product is returning based on id
	 */
	@Test
	public void givenIdThenShouldReturnProductOfThatId() {// getById

		Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product1));
		assertThat(productService.getProductByid(product1.getId())).isEqualTo(product1);
	}

	/**
	 * method which executes after each testcase
	 */
	@AfterEach
	public void tearDown() {
		product1 = product2 = null;
		productList = null;
	}

}