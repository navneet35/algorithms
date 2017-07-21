package com.java.designpatterns.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable{
  Queue<Integer> queue = null;
  int maxSize = 0;
  volatile int counter = 1;
  
  public Consumer(Queue<Integer> q, int maxSize) {
    this.queue = q;
    this.maxSize = maxSize;
  }

  @Override
  public void run() {
    while(counter++ < 10){
      synchronized(queue){
        try{
          if(queue.isEmpty()){
            System.out.println("Queue is empty now.");
            queue.wait();
          }
          System.out.println("Consumer consuming = " + queue.poll());
          queue.notify();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
    
  }

}
