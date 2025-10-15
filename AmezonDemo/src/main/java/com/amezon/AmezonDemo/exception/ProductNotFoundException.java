package com.amezon.AmezonDemo.exception;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
