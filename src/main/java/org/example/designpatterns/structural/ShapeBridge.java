package org.example.designpatterns.structural;

public abstract class ShapeBridge {
    protected DrawingAPIBridge drawingAPI;

    protected ShapeBridge(DrawingAPIBridge drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}
