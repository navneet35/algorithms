package com.java.multithreading;

import java.util.LinkedList;
import java.util.List;

public class CustomResourcePool<E> implements IResourcePool<E>{

	private List<E> pool;
	private int max = 10;
	
	public CustomResourcePool() {
		pool = new LinkedList<E>();
	}
	
	public CustomResourcePool(int limit) {
		pool = new LinkedList<E>();
		max = limit;
	}
	
	@Override
	public E get() throws InterruptedException {
		synchronized (pool) {
			if(pool.size() >= max){
				System.out.println("pool full. Waiting for consumer");
				pool.wait();
			}
			
			pool.notifyAll();
		}
		if(pool.size() > 0){
			E r =  pool.get(0);
			pool.remove(0);
			return r;
		}
		
		return null;
	}

	@Override
	public void put(E e) throws InterruptedException {
		synchronized (pool) {
			if(pool.size() >= max){
				System.out.println("pool full. Waiting....");
				pool.wait();
			}
			
			System.out.println("resource added = " + e);
			pool.add(e);
			pool.notifyAll();
		}
	}
	

}