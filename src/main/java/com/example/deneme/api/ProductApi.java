package com.example.deneme.api;

import com.example.deneme.dto.ProductDto;
import com.example.deneme.dto.ProductResponseDto;
import com.example.deneme.entities.Product;
import com.example.deneme.service.ProdutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {
    private final ProdutService produtService;

    @GetMapping
    public List<Product> findAll() {
        return produtService.findAll();
    }

    @PostMapping
    public ProductResponseDto save(@RequestBody ProductDto productDto) {
        return produtService.save(productDto);
    }
    @GetMapping("{id}")
    public Product findById(@PathVariable Long id) {
        return produtService.findById(id);
    }
    @GetMapping("/name/{name}")
    public Product findByName(@PathVariable String name){
        return produtService.findByName(name);
    }
    @GetMapping("/price/{price}")
    public List<Product> findByName(@PathVariable Double price){
        return produtService.findAllByPriceGreaterThanEqual(price);
    }
}
