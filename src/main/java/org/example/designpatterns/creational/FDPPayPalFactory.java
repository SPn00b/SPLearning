package org.example.designpatterns.creational;

public class FDPPayPalFactory implements FDPPaymentGatewayFactory {
    public FDPPaymentGateway createPaymentGateway() {
        return new FDPPayPalGateway();
    }
}