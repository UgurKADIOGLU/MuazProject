package com.example.deneme.exception;

public class ProductNameExistException extends RuntimeException {
    public ProductNameExistException(String name) {
        super("Product not found : " + name);
    }
}
