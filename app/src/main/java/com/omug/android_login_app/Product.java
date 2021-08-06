package com.omug.android_login_app;

public class Product {
    private String ProductName;
    private double price;
    private int image;
    private String description;
    private int quantity;

    public Product(String productName, double price, int image, String description, int quantity) {
        ProductName = productName;
        this.price = price;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
