package com.amezon.AmezonDemo.service;

import com.amezon.AmezonDemo.exception.OrderNotFoundException;
import com.amezon.AmezonDemo.model.PurchaseOrder;
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
    public List<PurchaseOrder> getAllOrders() {
        return repo.findAll();
    }

    // Create new purchaseOrder
    public PurchaseOrder createOrder(PurchaseOrder purchaseOrder) {
        return repo.save(purchaseOrder);
    }

    // Get order by ID
    public PurchaseOrder getOrderById(int id) throws OrderNotFoundException {
        Optional<PurchaseOrder> order = repo.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new OrderNotFoundException("PurchaseOrder with ID " + id + " not found");
        }
    }

    // Update existing order
    public String updateOrder(int id, PurchaseOrder newPurchaseOrderData) {
        Optional<PurchaseOrder> existingOrder = repo.findById(id);
        if (existingOrder.isPresent()) {
            PurchaseOrder purchaseOrder = existingOrder.get();

            if (newPurchaseOrderData.getProductName() != null) purchaseOrder.setProductName(newPurchaseOrderData.getProductName());
            if (newPurchaseOrderData.getQuantity() != 0) purchaseOrder.setQuantity(newPurchaseOrderData.getQuantity());
            if (newPurchaseOrderData.getPrice() != 0) purchaseOrder.setPrice(newPurchaseOrderData.getPrice());
            if (newPurchaseOrderData.getCustomerName() != null) purchaseOrder.setCustomerName(newPurchaseOrderData.getCustomerName());
            if (newPurchaseOrderData.getStatus() != null) purchaseOrder.setStatus(newPurchaseOrderData.getStatus());

            repo.save(purchaseOrder);
            return "PurchaseOrder updated successfully!";
        } else {
            return "PurchaseOrder not found!";
        }
    }

    // Delete an order
    public String deleteOrder(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "PurchaseOrder deleted successfully!";
        } else {
            return "PurchaseOrder not found!";
        }
    }
}
