package com.java.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationsTest {
  String name;
  public AnnotationsTest(String name) {
    this.name = name;
  }
  
  @LoginRequired(username = "navneet")
  public void print(){
    System.out.println("Annotations Test :: in print; p =  name = " + name);
  }
  
  @LoginRequired(username = "navneet", password = "navneet")
  public void printTest(){
    System.out.println("Annotations Test :: in printTest;  name = " + name);
  }
  
  public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Class<AnnotationsTest> c = AnnotationsTest.class;
    for(Method m : c.getDeclaredMethods()){
       if(m.isAnnotationPresent(LoginRequired.class)){
         AnnotationsTest o1 = new AnnotationsTest("First object");
         AnnotationsTest o2 = new AnnotationsTest("Second object");
         m.invoke(o1, 1);
         System.out.println(m.getAnnotation(LoginRequired.class).username());
         System.out.println(m.getAnnotation(LoginRequired.class).password());
       }
    }

  }

}
