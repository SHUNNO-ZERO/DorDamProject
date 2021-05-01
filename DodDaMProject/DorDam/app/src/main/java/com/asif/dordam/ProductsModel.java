package com.asif.dordam;

public class ProductsModel {

    private String brand;
    private String description;
    private String name;
    private long price;
    private long qty;

    private ProductsModel(){ }

    private ProductsModel(String brand,String description,String name,long price,long qty){
        this.brand=brand;
        this.description=description;
        this.name=name;
        this.price=price;
        this.qty=qty;

    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }
}
