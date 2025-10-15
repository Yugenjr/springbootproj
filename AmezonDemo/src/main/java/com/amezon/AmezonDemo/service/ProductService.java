package com.amezon.AmezonDemo.service;

import com.amezon.AmezonDemo.exception.ProductNotFoundException;
import com.amezon.AmezonDemo.model.Product;
import com.amezon.AmezonDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product createProduct(Product product) {
        return repo.save(product);
    }
    public String getAllProductById (int id) throws ProductNotFoundException{
        Optional<Product> products = repo.findById(id);
        if(products.isPresent())
        {
            Product obj = products.get();
            return obj.toString();
        }
        else {
            throw new ProductNotFoundException("Product"+id+"not found");
        }
    }
    public String updateProduct(int id,Product product)
    {
        Optional<Product> products = repo.findById(id);
        if(products.isPresent())
        {
            Product obj = products.get();
            if(product.getName()!=null)obj.setName(product.getName());
            if(product.getDescription()!=null)obj.setDescription(product.getDescription());
            if(product.getPrice()!=0)obj.setPrice(product.getPrice());
            if(product.getReview()!=null)obj.setReview(product.getReview());
            if(product.getQuantity()!=0)obj.setQuantity(product.getQuantity());
            repo.save(obj);
            return "updated successfully ";
        }
        else {
            return "Product Not Found";
        }
    }
}
