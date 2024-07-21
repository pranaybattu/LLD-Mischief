package org.vendingMachine.model;

import org.vendingMachine.enums.ProductType;

public class Product {
    private String name;
    private int id;
    private double price;
    private ProductType type;

    public Product(String name, int id, double price, ProductType type) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.type = type;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }
}
