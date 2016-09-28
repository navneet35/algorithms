package designpatterns.observerpattern;

import java.util.List;

public interface Observer {
	void update(List<Notification> notification);
}
