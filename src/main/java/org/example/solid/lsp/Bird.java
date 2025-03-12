package org.example.solid.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bird extends Flyable {
    Logger logger1 = LogManager.getLogger(Bird.class);

    @Override
    public void fly() {
        logger1.info("Bird is flying as per LSP in Solid");
    }
}
