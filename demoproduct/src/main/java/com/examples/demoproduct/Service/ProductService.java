package com.examples.demoproduct.Service;


import java.util.List;

import com.examples.demoproduct.model.Product;

public interface ProductService {

     Product addProduct(Product product);
    List<Product> getAllProducts();
     Product getProductByid(int id);
    Product deleteProductById(int id);
   



}