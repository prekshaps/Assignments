package com.examples.demoproduct.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examples.demoproduct.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {



}