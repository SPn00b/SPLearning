package org.example.solid.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Penguin {
    Logger logger = LogManager.getLogger(Penguin.class);

    public void swim() {
        logger.info("Penguin does not extend Bird in LSP as it does not have flying capability");
    }
}
