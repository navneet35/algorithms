package com.java.designpatterns.chainofresponsibility;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class FileLogger extends AbstractLogger {

    FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard File Logger::" + message);
    }
}
