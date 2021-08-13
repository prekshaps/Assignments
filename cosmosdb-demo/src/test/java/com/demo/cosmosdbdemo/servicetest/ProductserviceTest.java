package com.demo.cosmosdbdemo.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.azure.data.cosmos.PartitionKey;
import com.demo.cosmosdbdemo.model.Product;
import com.demo.cosmosdbdemo.repository.ProductRepository;
import com.demo.cosmosdbdemo.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductserviceTest {

	@Mock
	private ProductRepository productRepository;

	@Autowired
	@InjectMocks
	private ProductService productService;
	private Product product1;
	private Product product2;
	List<Product> productList;

	@BeforeEach
	public void setUp() {
		productList = new ArrayList<>();
		product1 = new Product("1", "apple", 200, "fruites");
		product2 = new Product("2", "potato", 300, "vegetables");
		productList.add(product1);
		productList.add(product2);
	}

	@Test
	public void saveProductTest() {
		productRepository.save(product1);
		when(productRepository.findAll()).thenReturn(productList);
		assertEquals(productRepository.save(product1), productList);
		verify(productRepository, times(1)).save(product1);
		verify(productRepository, times(1)).findAll();
	}

	@Test
	public void givenIdToDeleteThenShouldDeleteTheProduct() {
		when(productRepository.findById("1", new PartitionKey("apple")))
				.thenReturn(Optional.ofNullable(product1));
		assertThat(productService.findById(product1.getProductid(), product1.getProductCategory())).isEqualTo(product1);

	}

	@Test
	public void givenIdThenShouldReturnProductOfThatId() {// getById

		Mockito.when(productRepository.findById("1", new PartitionKey("apple")))
				.thenReturn(Optional.ofNullable(product1));
		assertThat(productService.findById(product1.getProductid(), product1.getProductCategory())).isEqualTo(product1);
	}

	@AfterEach
	public void tearDown() {
		product1 = product2 = null;
		productList = null;
	}

}