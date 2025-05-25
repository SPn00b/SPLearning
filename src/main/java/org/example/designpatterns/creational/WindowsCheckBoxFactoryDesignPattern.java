package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WindowsCheckBoxFactoryDesignPattern implements CheckBoxFactoryDesignPattern {

    private final static Logger logger = LogManager.getLogger(WindowsCheckBoxFactoryDesignPattern.class);

    @Override
    public void paint() {
        logger.info("Factory Design pattern Windows CheckBox Created");
    }
}
