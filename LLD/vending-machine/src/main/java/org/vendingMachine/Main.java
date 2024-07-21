package org.vendingMachine;

import org.vendingMachine.controller.AdminController;
import org.vendingMachine.controller.CustomerController;

public class Main {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();
        CustomerController customerController = new CustomerController();

        // Example actions
        adminController.addProduct("Chocolate", 1, 1.50, "CHOCOLATE");
        customerController.insertMoney(2.00);
        customerController.pressButton(1);
    }
}