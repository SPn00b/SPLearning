package org.example.designpatterns.creational;

public class FDPPayPalGateway implements FDPPaymentGateway {
    public void processPayment(Payment payment) {
        System.out.println("Processing payment of " + payment.getAmount() + " " + payment.getCurrency() + " through PayPal");
    }

    public void refundPayment(Payment payment) {
        System.out.println("Refunding payment of " + payment.getAmount() + " " + payment.getCurrency() + " through PayPal");
    }
}
