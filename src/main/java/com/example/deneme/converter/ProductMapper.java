package com.example.deneme.converter;
import com.example.deneme.dto.CategoryByIdWithProduct;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.dto.ProductUpdateDto;
import com.example.deneme.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "category.id", source = "categoryId")
    Product convertToProdut(ProductDto productDto);
    @Mapping(target = "categoryId", source = "category.id")
    ProductResponseDto convertToProductResponseDt(Product product);
    @Mapping(target = "category.id", source = "categoryId")
    Product convertToProdut(ProductUpdateDto productUpdateDto);

    List<ProductResponseDto> convertToProductResponseDtoLis(List<Product> products);

    @Mapping(target = "categoryId", source = "category.id")
    CategoryByIdWithProduct CategoryByIdWithProduct(Product product);

    List<CategoryByIdWithProduct> CategoryByIdWithProductList(List<Product> products);
}
