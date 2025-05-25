package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MacButtonFactoryPattern implements ButtonFactoryPattern {
    Logger logger = LogManager.getLogger(MacButtonFactoryPattern.class);

    @Override
    public void paint() {
        logger.info("Factory Method Mac Button Created");
    }
}
