package com.java.multithreading;

public interface IResourcePool<E> {
	E get() throws InterruptedException;
	void put(E e) throws InterruptedException;
}
