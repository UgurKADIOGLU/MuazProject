package com.example.deneme.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_generator",sequenceName = "product_id_seq",
    allocationSize = 1,initialValue = 1)
    @
    private Long id;
    @Column(name = "product_name",unique = true)
    private String name;
    private String description;
    private Double price;
}
