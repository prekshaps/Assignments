package com.examples.demoproduct.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.demoproduct.model.Product;
import com.examples.demoproduct.Exception.BadRequestException;
import com.examples.demoproduct.Exception.ProductAlreadyExistsException;
import com.examples.demoproduct.Exception.ProductNotFoundException;
import com.examples.demoproduct.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;


    @Autowired
    public void setProductRepository(ProductRepository productRepository){

        this.productRepository =productRepository;
    }

    @Override
    public Product addProduct(Product product){
        if(productRepository.existsById(product.getId())){
            throw new ProductAlreadyExistsException();
        }
        if(product.getPrice()<100) {
        	throw new BadRequestException();
        }
        
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return (List<Product>) productRepository.findAll();
        
    }

    @Override
    public Product getProductByid(int id) {
    	Optional<Product> optionalpro = this.productRepository.findById(id);
    	if(!optionalpro.isPresent()) {
    		throw  new ProductNotFoundException();
    	}
    	
        return productRepository.findById(id).orElse(null);
        }

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