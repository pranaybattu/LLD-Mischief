package org.vendingMachine.model;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private List<Integer> productIds;
    private int rackNumber;
    private static final int MAX_PRODUCTS = 4;

    public Rack(int rackNumber) {
        this.rackNumber = rackNumber;
        this.productIds = new ArrayList<>();
    }

    public boolean isEmpty() {
        return productIds.isEmpty();
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public boolean addProduct(int productId) {
        if (productIds.size() < MAX_PRODUCTS) {
            productIds.add(productId);
            return true;
        } else {
            return false; // Cannot add more products, rack is full
        }
    }

    public boolean removeProduct(int productId) {
        return productIds.remove(Integer.valueOf(productId));
    }

    public int getRackNumber() {
        return rackNumber;
    }
}
