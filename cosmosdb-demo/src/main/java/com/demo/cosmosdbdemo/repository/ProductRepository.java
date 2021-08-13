package com.demo.cosmosdbdemo.repository;

import com.demo.cosmosdbdemo.model.Product;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
	List<Product> findByProductName(String productName);

	Object findById(String productid, String productCategory);

	
}
