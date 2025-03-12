package org.example.solid.voilation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crow implements BirdInterface {
    Logger logger = LogManager.getLogger(Crow.class);

    @Override
    public void flying(BirdInterface.birdType bT) {
        //Cannot assign height parameter at all to change as it is final and static in interface
        //BirdInterface.height=10;
        switch (bT) {
            case CROW:
                logger.info("Crow is flying");
                break;
            default:
                logger.info("default case selected");
        }
    }

    @Override
    public void makeSound(BirdInterface.birdType bT) {
        switch (bT) {
            case CROW:
                logger.info("Kaw kaw");
                break;
            default:
                logger.info("default case selected");
        }
    }


    // We can access the variables declared in interface but not change them
    public void getHeight() {
        logger.info("Crow is of height "+BirdInterface.height+" cm");
    }
}
