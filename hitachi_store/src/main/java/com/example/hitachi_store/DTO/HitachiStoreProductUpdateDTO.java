package com.example.hitachi_store.DTO;

public class HitachiStoreProductUpdateDTO {
    private int id;
    private String name;
    private int price;
    private int tax;
 
    public HitachiStoreProductUpdateDTO(int id, String name, int price, int tax) {
        this.id     = id;
        this.name   = name;
        this.price  = price;
        this.tax    = tax;
    }
 
    public HitachiStoreProductUpdateDTO() {
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
        return "HitachiStoreProductUpdateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", tax='" + tax + 
                '}';
    }
}
