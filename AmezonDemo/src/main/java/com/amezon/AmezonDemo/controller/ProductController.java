package com.amezon.AmezonDemo.controller;

import com.amezon.AmezonDemo.model.Product;
import com.amezon.AmezonDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
   private ProductService service;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "product-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        service.createProduct(product);
        return "redirect:/product";
}}
