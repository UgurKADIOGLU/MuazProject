package com.example.deneme.converter;

import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product convertToPoduct(ProductDto productDto){
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                //.category(productDto.getCategory())
                .stock(productDto.getStock())
                .isActive(productDto.getIsActive())
                .build();
        return product;
    }
    public ProductResponseDto converToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                //.category(product.getCategory())
                .stock(product.getStock())
                .isActive(product.getIsActive())
                .build();
        return productResponseDto;
    }


}
