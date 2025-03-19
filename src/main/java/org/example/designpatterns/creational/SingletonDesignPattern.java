package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class SingletonDesignPattern {
    private final static Logger logger = LogManager.getLogger(SingletonDesignPattern.class);

    private static SingletonDesignPattern singletonDesignPattern;

    private SingletonDesignPattern() {}

    public static synchronized SingletonDesignPattern getInstance() {
//        if (singletonDesignPattern != null) {
//            return singletonDesignPattern;
//        }
//        return new SingletonDesignPattern();

        return Objects.requireNonNullElseGet(singletonDesignPattern, SingletonDesignPattern::new);
    }

    public static void printSingleton() {
        logger.info("Hello Singleton print");
    }
}
