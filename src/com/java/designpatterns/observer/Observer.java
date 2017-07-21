package com.java.designpatterns.observer;

import java.util.List;

public interface Observer {
	void update(List<Notification> notification);
}
