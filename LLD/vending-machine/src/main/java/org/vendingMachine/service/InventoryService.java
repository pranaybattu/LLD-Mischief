package org.vendingMachine.service;

import org.vendingMachine.enums.ProductType;
import org.vendingMachine.model.Inventory;
import org.vendingMachine.model.Product;

public class InventoryService {
    private Inventory inventory = new Inventory();

    public void addProduct(String name, int id, double price, String type) {
        ProductType productType = ProductType.valueOf(type);
        Product product = new Product(name, id, price, productType);
        inventory.addProduct(product);
    }
}
