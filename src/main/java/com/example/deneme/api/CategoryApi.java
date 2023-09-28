package com.example.deneme.api;

import com.example.deneme.dto.CategoryResponseDto;
import com.example.deneme.dto.CategorySaveDto;
import com.example.deneme.entities.Category;
import com.example.deneme.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryApi {
    private final CategoryService categoryService;

    @PostMapping
    public Category save(Category category) {
        return categoryService.save(category);
    }

    @PostMapping("/converter")
    public CategoryResponseDto saveConverter(CategorySaveDto categorySaveDto) {
        return categoryService.saveConverter(categorySaveDto);
    }

    @PostMapping("/mapper")
    public CategoryResponseDto saveMapper(CategorySaveDto categorySaveDto) {
        return categoryService.saveMapper(categorySaveDto);
    }
}
