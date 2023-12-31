package com.example.deneme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDto {
    Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Boolean isActive;
    private Long categoryId;
}
