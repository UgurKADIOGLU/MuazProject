package com.example.deneme.dao;

import com.example.deneme.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Long> {
    boolean existsByName(String name);

}
