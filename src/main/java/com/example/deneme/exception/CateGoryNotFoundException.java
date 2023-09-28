package com.example.deneme.exception;

public class CateGoryNotFoundException extends RuntimeException {
    public CateGoryNotFoundException(Long id) {
        super("Category not found : " + id);
    }
}
