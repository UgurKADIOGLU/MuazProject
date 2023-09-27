package com.example.deneme.service;

import com.example.deneme.converter.ProductConverter;
import com.example.deneme.converter.ProductMapper;
import com.example.deneme.dao.ProductDao;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.dto.ProductUpdateDto;
import com.example.deneme.entities.Product;
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
        Product product = ProductMapper.INSTANCE.convertToProduct(productDto);
        Product save = productDao.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(save);
    }

    public List<ProductResponseDto> findAll() {

        return ProductMapper.INSTANCE.convertToProductResponseDtoList(productDao.findAll());
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

    public ProductResponseDto update(Product product) {

        return ProductMapper.INSTANCE.convertToProductResponseDto(productDao.save(product));
    }
}
