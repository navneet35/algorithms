package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerBlockingQueueTest {
	static class Producer implements Runnable{
		BlockingQueue<Integer> queue;
		int maxCount = 10;
		Producer(BlockingQueue<Integer> q){
			this.queue = q;
		}
		
		@Override
		public void run() {
			int i = 0;
			System.out.println("In producer");
			while(i < maxCount){
				try {
					System.out.println("Element produced = " + i);
					queue.put(i++);
				} catch (InterruptedException e) {
					System.out.println("Exception in producer");
					e.printStackTrace();
				}
			}
		}
		
	}

	static class Consumer implements Runnable{
		BlockingQueue<Integer> queue;
		Consumer(BlockingQueue<Integer> q){
			this.queue = q;
		}
		
		@Override
		public void run() {
			System.out.println("In consumer");
			while(true){
				try {
					System.out.println("Element consumed = " + queue.take());
				} catch (InterruptedException e) {
					System.out.println("Exception in consumer");
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BlockingQueue<Integer> q =  new ArrayBlockingQueue<Integer>(20);
		Thread producer = new Thread(new Producer(q));
		Thread consumer = new Thread(new Consumer(q));
		producer.start();
		consumer.start();
	}

}

