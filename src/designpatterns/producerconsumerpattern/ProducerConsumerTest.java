package designpatterns.producerconsumerpattern;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

  public static void main(String[] args) {
    Queue<Integer> sharedQueue = new LinkedList<Integer>();
    Thread producer = new Thread(new Producer(sharedQueue, 5));
    Thread consumer = new Thread(new Consumer(sharedQueue, 5));
    producer.start();
    consumer.start();
  }

}
