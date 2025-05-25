package org.example.designpatterns.creational;

public class FDPPaymentProcessor {
    private final FDPPaymentGateway paymentGateway;

    public FDPPaymentProcessor(FDPPaymentGatewayFactory factory) {
        paymentGateway = factory.createPaymentGateway();
    }

    public void processPayment(Payment payment) {
        paymentGateway.processPayment(payment);
    }

    public void refundPayment(Payment payment) {
        paymentGateway.refundPayment(payment);
    }
}
