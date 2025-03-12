package org.example.solid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crow extends AbstractBird{
    private static final Logger logger = LogManager.getLogger(Crow.class);

    // again 2 methods break the SRP in the child overriden class
    @Override
    public void flying() {
        logger.info("Crow is flying");
    }

    @Override
    public void makeSound() {
        logger.info("Kaw Kaw");
    }

    public  void getHeight() {
        height = 20;
        logger.info("height of Crow is "+height+ " cm");
    }
}
