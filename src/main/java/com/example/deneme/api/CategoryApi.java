package com.example.deneme.api;

import com.example.deneme.dto.CategoryResponseDto;
import com.example.deneme.dto.CategorySaveDto;
import com.example.deneme.entities.Category;
import com.example.deneme.exception.CateGoryNotFoundException;
import com.example.deneme.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/findAllMapper")
    public List<CategoryResponseDto> findAllMapper(){
        return categoryService.findAllMapper();
    }
    @GetMapping("/findAllConverter")
    public List<CategoryResponseDto> findAllConverter(){
        return categoryService.findAllMapper();
    }
    @GetMapping("/findById/{id}")
    public Category findById(Long id){
        return categoryService.findById(id);
    }
    @GetMapping("/findByIdConverter/{id}")
    public CategoryResponseDto findByIdConverter(Long id){
        return categoryService.findByIdConverter(id);
    }
    @GetMapping("/findByIdMapper/{id}")
    public CategoryResponseDto findByIdMapper(Long id){
        return categoryService.findByIdMapper(id);
    }
}
