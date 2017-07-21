package com.java.multithreading;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueue<E> implements CustomBlockingQueue<E>{
  List<E> queue;
  int maxSize;
  
  public LinkedBlockingQueue(int size) {
    queue = new LinkedList<E>();
    this.maxSize = size;
  }
  
  @Override
  public synchronized void put(E item) throws InterruptedException {
    if(queue.size() == maxSize){
      System.out.println("Queue is Full. Wait!!");
      this.wait();
    }
    queue.add(item);
    this.notifyAll();
  }

  @Override
  public synchronized E take() throws InterruptedException {
    if(queue.size() == 0){
      System.out.println("Queue is Empty. Wait!!");
      this.wait();
    }
    E item = queue.remove(0);
    this.notifyAll();
    return item;
  }

  @Override
  public int size() {
    return queue.size();
  }

}
