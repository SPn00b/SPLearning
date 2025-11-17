package org.example.designpatterns.structural;

public class SquarePegAdaptorAdapterStructuralPattern extends RoundPegAdaptorStructuralPattern {

    private SquarePegAdaptorStructuralPattern peg;

    public SquarePegAdaptorAdapterStructuralPattern(SquarePegAdaptorStructuralPattern peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }

}
