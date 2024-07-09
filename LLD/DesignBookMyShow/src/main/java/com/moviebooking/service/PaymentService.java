package com.moviebooking.service;

import com.moviebooking.strategy.payment.PaymentStrategy;

public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(amount);
            System.out.println("Payment processed: $" + amount);
        } else {
            System.out.println("No payment strategy set");
        }
    }
}
