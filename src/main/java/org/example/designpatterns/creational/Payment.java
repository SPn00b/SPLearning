package org.example.designpatterns.creational;

public class Payment {
    private final String paymentMethod;
    private final double amount;
    private final String currency;

    public Payment(String paymentMethod, double amount, String currency) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}