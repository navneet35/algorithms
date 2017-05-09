package linkedlist;

public class SinglyLinkedListTest {
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		//create a loop
//		list.getFirst().getNext().getNext().getNext().setNext(list.getFirst().getNext());//connect 4 -> 2
		list.printList();
		System.out.println(list.ifContainsLoop());
		list.setFirst(SinglyLinkedList.reverse(list.getFirst(), 3));
		list.printList();
	}

}
