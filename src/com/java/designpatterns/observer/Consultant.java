/**
 * 
 */
package com.java.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Consultant implements Subject{
	List<Observer> observers;
	List<Notification> notifications;

	public Consultant() {
		observers = new ArrayList<Observer>();
		notifications = new ArrayList<Notification>();
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : observers)
			o.update(notifications);
	}
	
	public void getNotification(List<Notification> notifications){
		this.notifications.clear();
		this.notifications.addAll(notifications);
		notifyObserver();
	}

}
