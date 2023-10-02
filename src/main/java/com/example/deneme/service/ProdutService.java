package com.example.deneme.service;

import com.example.deneme.converter.ProductConverter;
import com.example.deneme.converter.ProductMapper;
import com.example.deneme.dao.ProductDao;
import com.example.deneme.dto.CategoryByIdWithProduct;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Product;
import com.example.deneme.exception.ProductNameExistException;
import com.example.deneme.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.deneme.helper.LogHelperService.*;

@Service
@RequiredArgsConstructor
public class ProdutService {
    private final ProductDao productDao;
    private final ProductConverter productConverter;
    private final String className=this.getClass().getSimpleName();

    public ProductResponseDto save(ProductDto productDto) {
        String methodName= getMethodName(new Throwable());
        startLogger(className,methodName);
        if (productDao.existsByName(productDto.getName()))
            throw new ProductNameExistException(productDto.getName());

        Product product = ProductMapper.INSTANCE.convertToProdut(productDto);
        Product productSave = productDao.save(product);
        ProductResponseDto responseDto=ProductMapper.INSTANCE.convertToProductResponseDt(productSave);
        objectLogger(className,methodName,productDto);
        finishLogger(className,methodName);
        return responseDto;
    }

    public List<ProductResponseDto> findAll() {

        List<ProductResponseDto> dto = ProductMapper.INSTANCE.convertToProductResponseDtoLis(productDao.findAll());
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
        return ProductMapper.INSTANCE.convertToProductResponseDt(productDao.save(product));
    }
    public List<CategoryByIdWithProduct> find(Long id){
        return ProductMapper.INSTANCE.CategoryByIdWithProductList(productDao.findAllByCategory_Id(id));
    }
}
