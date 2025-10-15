package com.amezon.AmezonDemo.controller;

import com.amezon.AmezonDemo.model.Product;
import com.amezon.AmezonDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        service.createProduct(product);
        return "Created successfully!";
    }

    @GetMapping("/{id}")
    public String getAllProductById(@PathVariable int id) {
        return service.getAllProductById(id);
    }
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id,product);
    }
}
