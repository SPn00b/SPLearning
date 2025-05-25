package org.example.designpatterns.creational;

public class FDPStripeFactory implements FDPPaymentGatewayFactory {
    public FDPPaymentGateway createPaymentGateway() {
        return new FDPStripeGateway();
    }
}
