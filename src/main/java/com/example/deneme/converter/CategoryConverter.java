package com.example.deneme.converter;

import com.example.deneme.dto.CategoryResponseDto;
import com.example.deneme.dto.CategorySaveDto;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Category;
import com.example.deneme.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryConverter {
    public Category map(CategorySaveDto categorySaveDto) {
        Category category = Category.builder()
                .name(categorySaveDto.getName())
                .build();
        return category;
    }

    public CategoryResponseDto map(Category category) {
        CategoryResponseDto categoryResponseDto = CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryResponseDto;
    }

    public List<CategoryResponseDto> map(List<Category> categories) {
        if (categories == null) return null;
        return categories.stream().map(this::map).toList();
    }


}
