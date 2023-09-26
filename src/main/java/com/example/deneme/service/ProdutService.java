package com.example.deneme.service;

import com.example.deneme.dao.ProductDao;
import com.example.deneme.entities.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutService {
    private final ProductDao productDao;

    public Product save(Product product){
        return productDao.save(product);
    }
    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }
    public Product findByName(String name){
        return productDao.findByName(name);
    }
    public List<Product> findAllByPriceGreaterThanEqual(Double price){
        return productDao.findAllByPriceGreaterThanEqual(price);
    }
}
