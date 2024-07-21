package org.vendingMachine.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int noOfProducts;
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Rack rack, Product product) {
        products.add(product);
        rack.addProduct(product.getId());
        noOfProducts++;
    }

    public void removeProduct(Product product) {
        products.remove(product);
        noOfProducts--;
    }

    // Getters and setters
    public int getNoOfProducts() {
        return noOfProducts;
    }

    public List<Product> getProducts() {
        return products;
    }
}