package com.amezon.AmezonDemo.controller;

import com.amezon.AmezonDemo.model.Order;
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
        public List<Order> getAllOrders()
        {
            return service.getAllOrders();
        }
        @PostMapping
        public String createOrder(@RequestBody Order order)
        {
            service.createOrder(order);
            return "Order created";
        }
        @PutMapping("/{id}")
        public String updateOrder(@PathVariable int id, @RequestBody Order order)
        {
            return service.updateOrder(id,order);
        }
        @DeleteMapping("/{id}")
        public String deleteOrder(@PathVariable int id)
        {
            return service.deleteOrder(id);
        }
    }
