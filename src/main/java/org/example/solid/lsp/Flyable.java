package org.example.solid.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Flyable {
    Logger logger = LogManager.getLogger(Flyable.class);
    public abstract void fly();
}
