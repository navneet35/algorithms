package designpatterns.observerpattern;

import java.util.Arrays;

public class NotificationTest {

	public static void main(String[] args) {
		Notification google = new JobNotification("SDE", "Google", "Hi, We have an opening.", 1);
		Consultant consultant = new Consultant();
		Client client = new Client("Jack");
		consultant.registerObserver(client);
		consultant.getNotification(Arrays.asList(google));
		Notification fb = new JobNotification("SDE", "Facebook", "Hi, We have an opening.", 1);
		Notification amazon = new JobNotification("SDE", "Amazon", "Hi, We have an opening.", 1);
		consultant.getNotification(Arrays.asList(fb, amazon));
	}

}
