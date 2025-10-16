package com.amezon.AmezonDemo.service;

import com.amezon.AmezonDemo.exception.OrderNotFoundException;
import com.amezon.AmezonDemo.model.Order;
import com.amezon.AmezonDemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    // Get all orders
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    // Create new order
    public Order createOrder(Order order) {
        return repo.save(order);
    }

    // Get order by ID
    public Order getOrderById(int id) throws OrderNotFoundException {
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
    }

    // Update existing order
    public String updateOrder(int id, Order newOrderData) {
        Optional<Order> existingOrder = repo.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();

            if (newOrderData.getProductName() != null) order.setProductName(newOrderData.getProductName());
            if (newOrderData.getQuantity() != 0) order.setQuantity(newOrderData.getQuantity());
            if (newOrderData.getPrice() != 0) order.setPrice(newOrderData.getPrice());
            if (newOrderData.getCustomerName() != null) order.setCustomerName(newOrderData.getCustomerName());
            if (newOrderData.getStatus() != null) order.setStatus(newOrderData.getStatus());

            repo.save(order);
            return "Order updated successfully!";
        } else {
            return "Order not found!";
        }
    }

    // Delete an order
    public String deleteOrder(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Order deleted successfully!";
        } else {
            return "Order not found!";
        }
    }
}
