package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.Id;

/**
 * Product class as Pojo class
 * 
 * @author P7112764
 *
 */
@Entity
public class Product {

	/**
	 * Represents the id of product
	 */
	@Id
	private int id;
	/**
	 * Represents the name of product
	 */
	private String name;
	/**
	 * Represents the price of product
	 */
	private float price;

	/**
	 * class Constructor
	 */
	public Product() {
	}

	/**
	 * class constructor with the fields
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * 
	 * @return Returns the id of the product
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id Accepts the id of product and set it on Product Object
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return Returns the name of the product
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name accepts the name of the product
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Returns the price of the product
	 */

	public float getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price accepts the price of product
	 */

	public void setPrice(float price) {
		this.price = price;
	}

}