package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MacCheckBoxFactoryDesignPattern implements CheckBoxFactoryDesignPattern {

    private final static Logger logger = LogManager.getLogger(MacCheckBoxFactoryDesignPattern.class);

    @Override
    public void paint() {
        logger.info("Factory Design Pattern Mac CheckBox Created");
    }
}
