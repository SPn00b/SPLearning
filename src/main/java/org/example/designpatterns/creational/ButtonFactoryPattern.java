package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ButtonFactoryPattern {
    Logger logger = LogManager.getLogger(ButtonFactoryPattern.class);

    void paint();
}
