package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WindowsButtonFactoryPattern implements ButtonFactoryPattern {
    final Logger logger = LogManager.getLogger(WindowsButtonFactoryPattern.class);

    @Override
    public void paint() {
        logger.info("Factory Method Windows Button Created");
    }
}
