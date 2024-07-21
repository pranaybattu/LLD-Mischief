package org.vendingMachine.state.vmState;

import org.vendingMachine.model.VendingMachine;
import org.vendingMachine.state.VMState;

public class DispenseState implements VMState {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Please wait, dispensing product...");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("Please wait, dispensing product...");
    }

    @Override
    public void returnChange(VendingMachine machine, double amount) {
        System.out.println("Returning change: $" + amount);
        machine.resetAmount();
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("Inventory updated at rack " + rackNumber);
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Product dispensed from rack " + rackNumber);
        machine.resetAmount();
        machine.setCurrentState(new NoMoneyInsertedState());
    }
}
