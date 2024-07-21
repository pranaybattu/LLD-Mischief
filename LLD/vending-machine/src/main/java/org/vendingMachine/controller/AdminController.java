package org.vendingMachine.controller;

import org.vendingMachine.service.InventoryService;

public class AdminController {
    private InventoryService inventoryService = new InventoryService();

    public void addProduct(String name, int id, double price, String type) {
        inventoryService.addProduct(name, id, price, type);
    }
}
