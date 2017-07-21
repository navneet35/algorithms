package com.java.designpatterns.observer;

public interface Subject {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver();
}
