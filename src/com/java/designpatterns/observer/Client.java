package com.java.designpatterns.observer;

import java.util.List;

public class Client implements Observer{
	private String name;
	public Client(){
		
	}
	
	public Client(String name){
		this.name = name;
	}

	@Override
	public void update(List<Notification> notifications) {
		for(Notification n : notifications)
			notificationInInbox(n);
	}
	
	public void notificationInInbox(Notification notification){
		System.out.println("Dear " + name + " : New Mail in Inbox");
		if(notification instanceof JobNotification){
			JobNotification jn = (JobNotification) notification;
			System.out.println("Type : " + jn.TYPE);
			System.out.println("Company : " + jn.getCompany());
			System.out.println("Position : " + jn.getPosition());
			System.out.println("Description : " + jn.getDescription());
			System.out.println("Priority : " + jn.getPriority());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
