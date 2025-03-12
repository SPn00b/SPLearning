package org.example.solid.voilation.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bird {
    Logger logger = LogManager.getLogger(Bird.class);
    public void fly() {
        logger.info("LSP voilating Bird base parent class method fly");
    }
}
