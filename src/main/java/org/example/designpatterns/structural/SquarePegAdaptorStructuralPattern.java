package org.example.designpatterns.structural;

public class SquarePegAdaptorStructuralPattern {

    private double width;

    public SquarePegAdaptorStructuralPattern(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }

}
