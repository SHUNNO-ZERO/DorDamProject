package com.asif.dordam2;

public class chittagang_p {

    private String name, brand, description;
    private double price;
    private int qty;

    public chittagang_p(){

    }

    public chittagang_p(String name, String brand, String description, double price, int qty) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }


}
