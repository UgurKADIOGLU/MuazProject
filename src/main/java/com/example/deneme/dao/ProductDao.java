package com.example.deneme.dao;

import com.example.deneme.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Long> {
    Product findByName(String name);

    List<Product> findAllByPriceGreaterThanEqual(Double price);

}
