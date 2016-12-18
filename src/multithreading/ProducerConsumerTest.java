package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
	static class Producer implements Runnable{
		private Queue<Integer> queue;
		private int maxCount = 10; 
				
		Producer(Queue<Integer> q){
			this.queue = q;
		}
		
		@Override
		public void run() {
			int i = 0;
			try{
				while(i < maxCount){
					produce(i++);
				}
			}catch(InterruptedException e){
				System.out.println("Exception in producer");
				e.printStackTrace();
			}
		}
		
		private void produce(int item) throws InterruptedException{
			synchronized (queue) {
				if(queue.size() >= maxCount){
					System.out.println("Queue full. Waiting for consumer");
					queue.wait();
				}
				
				System.out.println("Element produced = " + item);
				queue.offer(item);
				queue.notifyAll();
			}
		}
		
	}

	static class Consumer implements Runnable{
		private Queue<Integer> queue;
		
		Consumer(Queue<Integer> q) {
			this.queue = q;
		}
		
		@Override
		public void run() {
			try{
				while(true){
					consumer();
				}
			}catch(InterruptedException e){
				System.out.println("Exception in Consumer");
				e.printStackTrace();
			}
		}
		
		private void consumer() throws InterruptedException{
			synchronized (queue) {
				if(queue.size() <= 0){
					System.out.println("Queue is empty. Waiting for producer");
					queue.wait();
				}
				
				System.out.println("Element consumed = " + queue.poll());
				queue.notifyAll();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		Thread producer = new Thread(new Producer(q));
		Thread consumer = new Thread(new Consumer(q));
		producer.start();
		consumer.start();
	}

}
