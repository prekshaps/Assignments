package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.BadRequestException;
import com.example.demo.Exception.ProductAlreadyExistsException;
import com.example.demo.Service.ProductService;

import com.example.demo.model.Product;

/**
 * Controller class specifies the endpoints ("api/v1")
 * 
 * @author P7112764
 *
 */
@RestController
@RequestMapping("api/v1")
public class ProductController {
	/**
	 * Represents the logic for methods
	 */
	private ProductService productService;

	/**
	 * Constructor that accepts the productService
	 * 
	 * @param productService
	 */
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 
	 * @param product accepts the product as argument
	 * @return Returns the Response when it finds the endpoint ("product")
	 */
	@PostMapping("product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product saveProduct = productService.addProduct(product);

		return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return returns the all products when we use endpoint(products)
	 */
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>((List<Product>) productService.getAllProducts(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param id accepts the id as a parameter
	 * @return Returns the products when it find endpoint(product/{id})
	 */
	@GetMapping("product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product notPresent = productService.getProductByid(id);
		return new ResponseEntity<>(notPresent, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id accepts the id as argument
	 * @return Returns the response when it finds the endpoint (product/{id})
	 */
	@DeleteMapping("product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
		ResponseEntity responseEntity;
		Product deletedProduct = productService.deleteProductById(id);
		responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

		return responseEntity;
	}

}