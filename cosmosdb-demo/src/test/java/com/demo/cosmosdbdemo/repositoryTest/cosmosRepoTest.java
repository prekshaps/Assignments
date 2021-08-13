package com.demo.cosmosdbdemo.repositoryTest;

import com.azure.data.cosmos.PartitionKey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.demo.cosmosdbdemo.model.Product;
import com.demo.cosmosdbdemo.repository.ProductRepository;

@SpringBootTest
public class cosmosRepoTest {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void givenProductIsCreated_whenCallFindById_thenProductIsFound() {
		Product product = new Product("2", "apple", 110.0, "fruites");

		productRepository.save(product);
		Product retrievedProduct = productRepository.findById("2", new PartitionKey("apple")).orElse(null);
		Assert.notNull(retrievedProduct, "Retrieved Product is Null");
	}

}