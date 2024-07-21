package org.vendingMachine.service;

import org.vendingMachine.model.Rack;

public class RackService {
    public boolean isRackEmpty(Rack rack) {
        return rack.isEmpty();
    }
}
