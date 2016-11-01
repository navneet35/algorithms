package designpatterns.producerconsumerpattern;

import java.util.Queue;

public class Producer implements Runnable{
  Queue<Integer> queue = null;
  int maxSize = 0;
  volatile int counter = 1;
  
  public Producer(Queue<Integer> q, int maxSize) {
    this.queue = q;
    this.maxSize = maxSize;
  }
  
  @Override
  public void run() {
    while(counter < 10){
      synchronized(queue){
        try{
          if(queue.size() == maxSize){
            System.out.println("Queue is full now.");
            queue.wait();
          }
          System.out.println("Producer producing = " + counter);
          queue.offer(counter++);
          queue.notify();
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }
  }

}
