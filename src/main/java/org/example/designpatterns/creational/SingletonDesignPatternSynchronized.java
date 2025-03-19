package org.example.designpatterns.creational;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingletonDesignPatternSynchronized {
        private final static Logger logger = LogManager.getLogger(SingletonDesignPatternSynchronized.class);

        private static volatile SingletonDesignPatternSynchronized singletonDesignPattern;

    private SingletonDesignPatternSynchronized() {}

    public static SingletonDesignPatternSynchronized getInstance() {
        if (singletonDesignPattern == null) {
            synchronized (SingletonDesignPatternSynchronized.class) {
                if (singletonDesignPattern == null) {
                    singletonDesignPattern = new SingletonDesignPatternSynchronized();
                }
            }
        }
        return singletonDesignPattern;
    }

        public static void printSingleton() {
        logger.info("Hello Singleton print");
    }
}
