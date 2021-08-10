package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Exception.BadRequestException;
import com.example.demo.Exception.ProductAlreadyExistsException;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * provide logic for different methods to perform the different operation
 * 
 * @author P7112764
 * @version 11
 * 
 *
 */

@Service
public class ProductServiceImpl implements ProductService {
	/**
	 * To perform the different crud operations
	 */
	private ProductRepository productRepository;

	/**
	 * 
	 * @param productRepository
	 */

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	/**
	 * @return returns the product that we added
	 * @param accepts the product as a parameter
	 */
	@Override
	public Product addProduct(Product product) {
		if (productRepository.existsById(product.getId())) {
			throw new ProductAlreadyExistsException();
		}
		if (product.getPrice() < 100) {
			throw new BadRequestException();
		}

		return productRepository.save(product);
	}

	/**
	 * @return return the exits All products
	 */

	@Override
	public List<Product> getAllProducts() {

		return (List<Product>) productRepository.findAll();

	}

	/**
	 * @return returns the product by id
	 */

	@Override
	public Product getProductByid(int id) {
		Optional<Product> optionalpro = this.productRepository.findById(id);
		if (!optionalpro.isPresent()) {
			throw new ProductNotFoundException();
		}

		return productRepository.findById(id).orElse(null);
	}

	/**
	 * @return delete a product By id
	 */

	@Override
	public Product deleteProductById(int id) {
		Product product = null;
		Optional optional = productRepository.findById(id);
		if (optional.isPresent()) {
			product = productRepository.findById(id).get();
			productRepository.deleteById(id);
		}
		return product;
	}

}