package com.java.designpatterns.chainofresponsibility;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class LoggerMain {

    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage("This is an error information", AbstractLogger.ERROR);
        loggerChain.logMessage("This is a debug information", AbstractLogger.DEBUG);
        loggerChain.logMessage("This is an information", AbstractLogger.INFO);
    }

}
