package com.examples.demoproduct.service;




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.examples.demoproduct.model.Product;
import com.examples.demoproduct.Exception.ProductAlreadyExistsException;
import com.examples.demoproduct.Exception.ProductNotFoundException;
import com.examples.demoproduct.Repository.ProductRepository;
import com.examples.demoproduct.Service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceTest {

//handles business logic
    //unit testing so mocking
    @Mock
    private ProductRepository productRepository;

    @Autowired
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;
    List<Product> productList;

    @Before
    public void setUp() {
        productList = new ArrayList<>();
        product1 = new Product(1, "bread",20);
        product2 = new Product(2, "jam",200);
        productList.add(product1);
        productList.add(product2);
    }
    @Test
    public void GivenGetAllUsersShouldReturnListOfAllUsers() {
    	productRepository.save(product1);
    	when(productRepository.findAll()).thenReturn(productList);
    	List<Product> productList1 = productService.getAllProducts();
    	assertEquals(productList1,productList);
    	verify(productRepository,times(1)).save(product1);
    	verify(productRepository,times(1)).findAll();
    }
    
    
    @Test
    public void givenIdToDeleteThenShouldDeleteTheProduct() {
    	Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product1));
        assertThat(productService.getProductByid(product1.getId())).isEqualTo(product1);
    	
    }
    
    
   

    @Test
    public void givenIdThenShouldReturnProductOfThatId() {//getById

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product1));
        assertThat(productService.getProductByid(product1.getId())).isEqualTo(product1);
    }
    
    @After
    public void tearDown() {
        product1 = product2 = null;
        productList = null;
    }

   
   
}