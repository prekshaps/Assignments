package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
/**
 * Perfrom the different crud operation implements the JpaRepository
 * @author P7112764
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {



}