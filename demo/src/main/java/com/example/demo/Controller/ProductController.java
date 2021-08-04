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



@RestController
@RequestMapping("api/v1")
public class ProductController {
	
    private ProductService productService;
    
    
    public ProductController(ProductService productService) {
		this.productService = productService;
    }
    @PostMapping("product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        	Product saveProduct = productService.addProduct(product);
        
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts(){

        return new ResponseEntity<List<Product>>(
                (List <Product>) productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
    	Product notPresent = productService.getProductByid(id);
        return new ResponseEntity<>(notPresent,HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
        public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        Product deletedProduct = productService.deleteProductById(id);
        responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

        return responseEntity;
   }
    
   
    
   
}