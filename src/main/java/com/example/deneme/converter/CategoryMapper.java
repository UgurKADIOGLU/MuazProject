package com.example.deneme.converter;

import com.example.deneme.dto.*;
import com.example.deneme.entities.Category;
import com.example.deneme.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category map(CategorySaveDto categorySaveDto);
    CategoryResponseDto map(Category category);
    List<CategoryResponseDto> map(List<Category> categories);
}
