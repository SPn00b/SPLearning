package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MacGUIAbstractFactoryDesignPattern implements GUIAbstractFactoryDesignPattern {
    private static final Logger logger = LogManager.getLogger(MacGUIAbstractFactoryDesignPattern.class);


    @Override
    public ButtonFactoryPattern createButton() {
        return new MacButtonFactoryPattern();
    }

    @Override
    public CheckBoxFactoryDesignPattern createCheckBox() {
        return new MacCheckBoxFactoryDesignPattern();
    }
}
