package com.example.demo.Service;

import java.util.List;
import com.example.demo.model.Product;

/**
 * provide different methods
 * @author P7112764
 *
 */
public interface ProductService {

	Product addProduct(Product product);

	List<Product> getAllProducts();

	Product getProductByid(int id);

	Product deleteProductById(int id);

}