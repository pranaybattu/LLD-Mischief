package org.vendingMachine.service;

import org.vendingMachine.model.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine = VendingMachine.getInstance();

    public void insertMoney(double amount) {
        vendingMachine.insertMoney(amount);
    }

    public void pressButton(int rackNumber) {
        vendingMachine.pressButton(rackNumber);
    }
}
