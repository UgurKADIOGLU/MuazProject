package com.example.deneme.service;

import com.example.deneme.converter.ProductConverter;
import com.example.deneme.converter.ProductMapper;
import com.example.deneme.dao.ProductDao;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Product;
import com.example.deneme.exception.ProductNameExistException;
import com.example.deneme.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutService {
    private final ProductDao productDao;
    private final ProductConverter productConverter;
    //private final ProductMapper productMapper;

    public ProductResponseDto save(ProductDto productDto) {
        if (productDao.existsByName(productDto.getName()))
            throw new ProductNameExistException(productDto.getName());
        Product product = ProductMapper.INSTANCE.convertToProduct(productDto);
        Product save = productDao.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(save);
    }

    public List<ProductResponseDto> findAll() {

        List<ProductResponseDto> dto = ProductMapper.INSTANCE.convertToProductResponseDtoList(productDao.findAll());
        return dto;
    }

    public Product findById(Long id) {

        Product product = productDao.findById(id).orElseThrow(() -> {
            RuntimeException exception = new ProductNotFoundException(id);
            return exception;
        });
        return product;
    }

    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    public List<Product> findAllByPriceGreaterThanEqual(Double price) {
        return productDao.findAllByPriceGreaterThanEqual(price);
    }

    public ProductResponseDto update(Product product) {

        return ProductMapper.INSTANCE.convertToProductResponseDto(productDao.save(product));
    }
}
