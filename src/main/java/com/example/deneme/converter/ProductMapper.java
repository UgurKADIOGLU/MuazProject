package com.example.deneme.converter;

import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.dto.ProductUpdateDto;
import com.example.deneme.entities.Product;
import org.apache.catalina.LifecycleState;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product convertToProduct(ProductDto productDto);
    ProductResponseDto convertToProductResponseDto(Product product);
    Product convertToProduct(ProductUpdateDto productUpdateDto);
    List<ProductResponseDto> convertToProductResponseDtoList(List<Product> products);
}
