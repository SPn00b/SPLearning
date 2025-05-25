package org.example.designpatterns.creational;

public interface FDPPaymentGateway {
    void processPayment(Payment payment);

    void refundPayment(Payment payment);
}
