package com.example.deneme.service;

import com.example.deneme.converter.CategoryConverter;
import com.example.deneme.converter.CategoryMapper;
import com.example.deneme.converter.ProductConverter;
import com.example.deneme.converter.ProductMapper;
import com.example.deneme.dao.CategoryDao;
import com.example.deneme.dto.CategoryResponseDto;
import com.example.deneme.dto.CategorySaveDto;
import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Category;
import com.example.deneme.entities.Product;
import com.example.deneme.exception.CateGoryNotFoundException;
import com.example.deneme.exception.ProductNameExistException;
import com.example.deneme.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.deneme.helper.LogHelperService.*;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;
    private final CategoryConverter categoryConverter;
    private final String className=this.getClass().getSimpleName();

    public Category save(Category category) {
        return categoryDao.save(category);
    }
    public CategoryResponseDto saveConverter(CategorySaveDto categorySaveDto) {
        Category category=categoryConverter.map(categorySaveDto);
        Category categorySave=categoryDao.save(category);
        return categoryConverter.map(categorySave);
    }
    public CategoryResponseDto saveMapper(CategorySaveDto categorySaveDto) {
        Category category= CategoryMapper.INSTANCE.map(categorySaveDto);
        Category categorySave=categoryDao.save(category);
        return CategoryMapper.INSTANCE.map(categorySave);
    }
    public List<Category> findAll(){
        return categoryDao.findAll();
    }

    public List<CategoryResponseDto> findAllMapper() {
        return CategoryMapper.INSTANCE.map(categoryDao.findAll());
    }
    public List<CategoryResponseDto> findAllConverter() {
        return categoryConverter.map(categoryDao.findAll());
    }
    public Category findById(Long id){
        return categoryDao.findById(id).orElseThrow(()->new CateGoryNotFoundException(id));
    }
    public CategoryResponseDto findByIdConverter(Long id){
        return categoryConverter.map(categoryDao.findById(id).orElseThrow(()->new CateGoryNotFoundException(id)));
    }
    public CategoryResponseDto findByIdMapper(Long id){
        return CategoryMapper.INSTANCE.map(categoryDao.findById(id).orElseThrow(() -> new CateGoryNotFoundException(id)));
    }
}
