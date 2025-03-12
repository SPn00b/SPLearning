package org.example.solid.lsp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// I cannot extend Bird again to create a crow or any other class
// as the Bird class extends an abstract class the Bird class is needed to create instances
// by creating Corw etc class that extends the Flying class instead like run time polymorphism
// Instead of using abstraction this could be solved using interface by using ISP principle in SOLID
public class Crow /*extends Bird*/ {
    Logger logger = LogManager.getLogger(Crow.class);

//    @Override
//    public void fly() {
//        logger.info("Crow is flying as per LSP in Solid");
//    }
}
