package org.example.solid.voilation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bird {
    private static final Logger logger = LogManager.getLogger(Bird.class);

    String color;
    int weight;
    int height;
    int width;
    int length;
    public enum birdType {
        PIEGON,
        CROW,
        SPARROW,
        DUCK
    }


    // 2 methods break SRP as there are 2 reasons to change the class one for
    // flying
    // and
    // one for sounds
    public void flying(birdType bT) {
        switch (bT) {
            case PIEGON:
                logger.info("Pigeon is flying");
                break;
            case CROW:
                logger.info("Crow is flying");
                break;
            case SPARROW:
                logger.info("Sparrow is flying");
                break;
            case DUCK:
                logger.info("Duck is flying");
                break;
        }
    }

    public void makeSound(birdType bT) {
        switch (bT) {
            case PIEGON:
                logger.info("Coo coo"); // Corrected sound
                break;
            case CROW:
                logger.info("Kaw kaw");
                break;
            case SPARROW:
                logger.info("Chirp chirp"); // Corrected sound
                break;
            case DUCK:
                logger.info("Quack quack"); // Corrected sound
                break;
        }
    }
}
