package com.java.designpatterns.factory;

public abstract class Notification {
	private String description;
	private Integer priority;

	public Notification(){
		
	}
	
	public Notification(String description, Integer priority) {
		super();
		this.description = description;
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
