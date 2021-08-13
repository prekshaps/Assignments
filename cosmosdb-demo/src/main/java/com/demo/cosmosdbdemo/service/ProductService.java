package com.demo.cosmosdbdemo.service;

import com.azure.data.cosmos.PartitionKey;
import com.demo.cosmosdbdemo.Exception.BadRequestException;
import com.demo.cosmosdbdemo.Exception.ProductAlreadyExistsException;
import com.demo.cosmosdbdemo.Exception.ProductNotFoundException;
import com.demo.cosmosdbdemo.model.Product;
import com.demo.cosmosdbdemo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

	private ProductRepository repository;

	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Product> findProductByName(String productName) {
		return repository.findByProductName(productName);
	}

	public Optional<Product> findById(String productId, String category) {
		Optional<Product> optionalpro = this.repository.findById(productId);
		if (!optionalpro.isPresent()) {
			throw new ProductNotFoundException();
		}

		return Optional.of(repository.findById(productId, new PartitionKey(category)).orElse(null));
	}

	public void saveProduct(Product product) {
		if (product.getPrice() < 100) {
			throw new BadRequestException();
		}
		repository.save(product);
	}

	public void delete(String productId, String category) {
		repository.deleteById(productId, new PartitionKey(category));
	}
}