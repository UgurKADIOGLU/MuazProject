package com.example.deneme.service;

import com.example.deneme.converter.ProductConverter;
import com.example.deneme.dao.ProductDao;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutService {
    private final ProductDao productDao;
    private final ProductConverter productConverter;

    public ProductResponseDto save(ProductDto productDto) {
        Product product = productConverter.convertToPoduct(productDto);
        Product save = productDao.save(product);
        ProductResponseDto productResponseDto = productConverter.converToProductResponseDto(product);
        return productResponseDto;
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    public List<Product> findAllByPriceGreaterThanEqual(Double price) {
        return productDao.findAllByPriceGreaterThanEqual(price);
    }
}
