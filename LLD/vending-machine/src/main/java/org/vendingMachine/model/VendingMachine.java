package org.vendingMachine.model;

import org.vendingMachine.state.VMState;
import org.vendingMachine.state.vmState.NoMoneyInsertedState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VMState currentState;
    private double amount;
    private static int noOfRacks = 4;
    private List<Rack> racks;
    private List<Integer> availableRacks;

    // singleton
    private static VendingMachine vendingMachine;

    private VendingMachine() {
        this.currentState = new NoMoneyInsertedState();
        this.amount = 0.0;
        this.racks = new ArrayList<>();
        this.availableRacks = new ArrayList<>();
        for (int i = 1; i <= noOfRacks; i++) {
            racks.add(new Rack(i));
            availableRacks.add(i);
        }
    }

    public static VendingMachine getInstance() {
        if (vendingMachine == null) {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void pressButton(int rackNumber) {
        currentState.pressButton(this, rackNumber);
    }

    public void returnChange(VendingMachine machine, double amount) {
        currentState.returnChange(machine, amount);
    }

    public void updateInventory(int rackNumber) {
        currentState.updateInventory(this, rackNumber);
    }

    public void dispenseProduct(int rackNumber) {
        currentState.dispenseProduct(this, rackNumber);
    }

    public int getProductIdAtRack(int rackNumber) {
        // Example implementation to get product ID at a specific rack
        if (rackNumber >= 0 && rackNumber < racks.size()) {
            Rack rack = racks.get(rackNumber);
            if (!rack.isEmpty()) {
                return rack.getProductIds().get(0); // Get the first product ID in the rack
            }
        }
        return -1;
    }

    public void setCurrentState(VMState state) {
        this.currentState = state;
    }

    // Getters and setters for amount
    public double getAmount() {
        return amount;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void resetAmount() {
        this.amount = 0.0;
    }
}
