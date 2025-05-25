package org.example.designpatterns.creational;

public class FDPStripeGateway implements FDPPaymentGateway {
    public void processPayment(Payment payment) {
        System.out.println("Processing payment of " + payment.getAmount() + " " + payment.getCurrency() + " through Stripe");
    }

    public void refundPayment(Payment payment) {
        System.out.println("Refunding payment of " + payment.getAmount() + " " + payment.getCurrency() + " through Stripe");
    }
}
