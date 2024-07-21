package org.vendingMachine.state;

import org.vendingMachine.model.VendingMachine;

public interface VMState {
    void insertMoney(VendingMachine machine, double amount);
    void pressButton(VendingMachine machine, int rackNumber);
    void returnChange(VendingMachine machine, double amount);
    void updateInventory(VendingMachine machine, int rackNumber);
    void dispenseProduct(VendingMachine machine, int rackNumber);
}
