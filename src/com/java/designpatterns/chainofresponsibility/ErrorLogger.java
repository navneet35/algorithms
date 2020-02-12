package com.java.designpatterns.chainofresponsibility;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class ErrorLogger extends AbstractLogger {

    ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard Error Logger::" + message);
    }
}
