package com.demo.cosmosdbdemo.model;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

@Document(collection = "products")
public class Product {

	@Id
	private String productid;

	private String productName;

	public Product() {
		super();
	}

	public Product(String productid, String productName, double price, String productCategory) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.price = price;
		this.productCategory = productCategory;
	}

	private double price;

	@PartitionKey
	private String productCategory;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}