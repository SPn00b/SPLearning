package org.example.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;

public class ThreadTesting implements Runnable {
    final Logger logger = LogManager.getLogger(ThreadTesting.class);
    int count = 0;


    @Override
    public void run() {
        for (int i = 0; i <99999; i++ )
        {
            count++;
//            logger.info("Thread: Thread ID: {}, Thread Name: ()", Thread.currentThread().threadId(), Thread.currentThread().getName());
        }
        logger.info("Count :" + count);
    }
}
