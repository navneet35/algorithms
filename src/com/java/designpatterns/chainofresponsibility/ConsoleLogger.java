package com.java.designpatterns.chainofresponsibility;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class ConsoleLogger extends AbstractLogger {

    ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard Console Logger::" + message);
    }
}
