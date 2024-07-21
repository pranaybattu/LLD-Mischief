package org.vendingMachine.controller;

import org.vendingMachine.service.VendingMachineService;

public class CustomerController {
    private VendingMachineService vendingMachineService = new VendingMachineService();

    public void insertMoney(double amount) {
        vendingMachineService.insertMoney(amount);
    }

    public void pressButton(int rackNumber) {
        vendingMachineService.pressButton(rackNumber);
    }
}
