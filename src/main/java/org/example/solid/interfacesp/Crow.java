package org.example.solid.interfacesp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crow extends Bird {
    Logger logger = LogManager.getLogger(Crow.class);
    @Override
    public void fly() {
        super.color = "Black";
        logger.info("Crow is flying using Interface Segregation Principle with color: "+color);
    }
}
