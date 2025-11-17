package org.example.designpatterns.structural;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrawingAPI2Bridge implements DrawingAPIBridge {
    private static final Logger log = LogManager.getLogger(DrawingAPI2Bridge.class);

    @Override
    public void drawCircle(int x, int y, int radius) {
        log.info("API2: Drawing circle at ({}, {}) with radius {}", x, y, radius);
    }
}