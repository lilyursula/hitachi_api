package com.example.hitachi_store.entity;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "products")

public class HitachiStoreProduct {
    
    @Id
    @Column(name = "id", length = 12)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column(name = "name", length = 45)
    private String name;
 
    @Column(name = "price", length = 45)
    private int price;
 
    @Column(name = "tax", length = 12)
    private int tax;

    public HitachiStoreProduct(int id, String name, int price, int tax) {
        this.id     = id;
        this.name   = name;
        this.price  = price;
        this.tax    = tax;
    }

    public HitachiStoreProduct() {
    }

    public HitachiStoreProduct(String name, int price, int tax) {
        this.name   = name;
        this.price  = price;
        this.tax    = tax;
    }
 
    public int getProductId() {
        return id;
    }
 
    public void setProductId(int id) {
        this.id = id;
    }
 
    public String getProductName() {
        return name;
    }
 
    public void setProductName(String name) {
        this.name = name;
    }

    public int getProductPrice() {
        return price;
    }
 
    public void setProductPrice(int price) {
        this.price = price;
    }
 
    public int getProductTax() {
        return tax;
    }
 
    public void setProductTax(int tax) {
        this.tax = tax;
    }
 
    @Override
    public String toString() {
        return "HitachiStoreProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", tax='" + tax + 
                '}';
    }

}

