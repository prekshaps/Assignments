package com.example.demo.Service;


import java.util.List;
import com.example.demo.model.Product;

public interface ProductService {

     Product addProduct(Product product);
    List<Product> getAllProducts();
     Product getProductByid(int id);
    Product deleteProductById(int id);
   



}