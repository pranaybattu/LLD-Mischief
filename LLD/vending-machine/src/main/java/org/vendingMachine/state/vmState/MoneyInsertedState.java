package org.vendingMachine.state.vmState;

import org.vendingMachine.model.VendingMachine;
import org.vendingMachine.state.VMState;

public class MoneyInsertedState implements VMState {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Money already inserted. Current amount: $" + machine.getAmount());
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        int productId = machine.getProductIdAtRack(rackNumber);
        if (productId != -1) {
            // Assuming a product repository/service to get the product details
            double productPrice = machine.getAmount(); // Example, replace with actual product price
            if (machine.getAmount() >= productPrice) {
                machine.setCurrentState(new DispenseState());
                machine.dispenseProduct(rackNumber);
            } else {
                System.out.println("Insufficient money. Please insert more.");
            }
        } else {
            System.out.println("Product not available at rack " + rackNumber);
        }
    }

    @Override
    public void returnChange(VendingMachine machine, double amount) {
        System.out.println("Returning change: $" + amount);
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("Updating inventory at rack " + rackNumber);
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("Dispensing product...");
        machine.setCurrentState(new NoMoneyInsertedState());
    }
}
