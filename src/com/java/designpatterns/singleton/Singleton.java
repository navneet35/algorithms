package com.java.designpatterns.singleton;

public class Singleton {
  private Singleton(){
    System.out.println("In singleton constructor.");
  }
  
  private static class SingletonHelper{
    private static final Singleton SINGLETON_INSTANCE = new Singleton();
  }
  
  public static Singleton getInstance(){
    return SingletonHelper.SINGLETON_INSTANCE;
  }

}
