package com.java.designpatterns.observer;

public class JobNotification extends Notification{
	private String position;
	private String company;
	public final String TYPE = "Job Notification";

	public JobNotification(){
		
	}
	
	public JobNotification(String position, String company, String description, Integer priority) {
		super(description, priority);
		this.position = position;
		this.company = company;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
