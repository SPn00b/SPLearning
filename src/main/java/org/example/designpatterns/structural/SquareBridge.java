package org.example.designpatterns.structural;

public class SquareBridge extends ShapeBridge {
    private int x, y, radius;

    public SquareBridge(int x, int y, int radius, DrawingAPIBridge drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}
