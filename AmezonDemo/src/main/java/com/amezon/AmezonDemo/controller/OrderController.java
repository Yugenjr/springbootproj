package com.amezon.AmezonDemo.controller;

import com.amezon.AmezonDemo.model.PurchaseOrder;
import com.amezon.AmezonDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping
public class OrderController
    {
        @Autowired
        OrderService service;

        @GetMapping
        public List<PurchaseOrder> getAllOrders()
        {
            return service.getAllOrders();
        }
        @PostMapping
        public String createOrder(@RequestBody PurchaseOrder purchaseOrder)
        {
            service.createOrder(purchaseOrder);
            return "PurchaseOrder created";
        }
        @PutMapping("/{id}")
        public String updateOrder(@PathVariable int id, @RequestBody PurchaseOrder purchaseOrder)
        {
            return service.updateOrder(id, purchaseOrder);
        }
        @DeleteMapping("/{id}")
        public String deleteOrder(@PathVariable int id)
        {
            return service.deleteOrder(id);
        }
    }
