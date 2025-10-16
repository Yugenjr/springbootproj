package com.amezon.AmezonDemo.model;
import jakarta.persistence.*;

@Entity
public class Product
{
    // @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", quantity=" + quantity +
//                ", description='" + description + '\'' +
//                ", review='" + review + '\'' +
//                '}';
//    }
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int price;
    private int quantity;
    private String description;
    private String review;

    @ManyToOne
    @JoinColumn(name="order_id")
    private PurchaseOrder purchaseOrder;
    public PurchaseOrder getOrder() {
        return purchaseOrder;
    }
    public void setOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
