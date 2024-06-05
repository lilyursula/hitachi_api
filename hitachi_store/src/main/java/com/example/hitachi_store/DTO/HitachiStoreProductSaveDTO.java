package com.example.hitachi_store.DTO;

public class HitachiStoreProductSaveDTO {
    
    private String name;
    private int price;
    private int tax;
 
    public HitachiStoreProductSaveDTO(String name, int price, int tax) {
        this.name   = name;
        this.price  = price;
        this.tax    = tax;
    }
 
    public HitachiStoreProductSaveDTO() {
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
        return "HitachiStoreProductSaveDTO{" +
                ", name='" + name + 
                ", price='" + price + '\'' +
                ", tax='" + tax + 
                '}';
    }
}
