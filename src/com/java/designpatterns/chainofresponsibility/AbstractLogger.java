package com.java.designpatterns.chainofresponsibility;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    protected int level;
    protected AbstractLogger nextLogger;

    public void logMessage(String message, int level) {
        if(this.level <= level) {
            this.write(message);
        } else {
            nextLogger.logMessage(message, level);
        }
    }

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public abstract void write(String message);
}
