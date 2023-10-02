package com.example.deneme.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ProductDto {
    @NotNull(message = "Product can nut be null")
    private String name;
    @Size(min=10,max=200,message = "Product description must be between 10 and 200 characters")
    private String description;
    @Min(value = 10,message = "Product stock must be grether than 10")
    private Double price;
    private Integer stock;
    private Boolean isActive;
    private Long categoryId;
}
