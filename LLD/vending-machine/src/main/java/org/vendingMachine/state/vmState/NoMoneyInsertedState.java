package org.vendingMachine.state.vmState;

import org.vendingMachine.model.VendingMachine;
import org.vendingMachine.state.VMState;

public class NoMoneyInsertedState implements VMState {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addAmount(amount);
        System.out.println("Money inserted: $" + amount);
        machine.setCurrentState(new MoneyInsertedState());
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void returnChange(VendingMachine machine,double amount) {
        System.out.println("No money to return.");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("No inventory update possible in NoMoneyInserted state.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Please insert money first.");
    }
}
