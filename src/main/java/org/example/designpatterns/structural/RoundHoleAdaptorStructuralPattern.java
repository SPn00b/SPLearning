package org.example.designpatterns.structural;

public class RoundHoleAdaptorStructuralPattern {

    private double radius;

    public RoundHoleAdaptorStructuralPattern(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPegAdaptorStructuralPattern peg) {
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }

}
