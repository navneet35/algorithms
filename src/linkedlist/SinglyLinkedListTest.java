package linkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.printList();
		list.deleteNode(1);
		list.printList();
		list.add(4);
		list.add(5);
		list.printList();
		list.deleteNodeAtPosition(1);
		list.printList();
	}

}
