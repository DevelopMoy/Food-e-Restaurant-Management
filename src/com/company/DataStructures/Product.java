package com.company.DataStructures;

public class Product {
    private int idProduct;
    private String productName;
    private double price;
    private int cantidad;

    public Product(int idProduct, String productName, double price) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
