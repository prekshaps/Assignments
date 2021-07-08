package com.example.demo.Controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.BadArgumentException;
import com.example.demo.Exception.InternalException;
import com.example.demo.Exception.ProductAlreadyExistsException;
import com.example.demo.Exception.ResourceNotFoundException;
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
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
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
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
        public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        Product deletedProduct = productService.deleteProductById(id);
        responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);

        return responseEntity;
   }
    
    @GetMapping("/exception/{exception_id}")
    public void getSpecificException(@PathVariable("exception_id") String pException) {
    	if("not_found".equals(pException)) {
    		throw new ResourceNotFoundException("resource not found");
    		}
    	else if("bad_arguments".equals(pException)) {
    		throw new BadArgumentException("bad arguments");
    	}
    	else {
    		throw new InternalException("internal error");
    	}
    }
    
    @GetMapping("/exception/throw")
    public void getException() throws Exception{
      throw new Exception("error");
    }

}