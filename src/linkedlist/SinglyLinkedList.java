package linkedlist;

public class SinglyLinkedList<E> {
	private SingleNode<E> first;
	private SingleNode<E> last;
	private int size;
	
	public void printList(){
		if(size == 0){
			System.out.println("No nodes in the list");
			return;
		}
		
		for(SingleNode<E> temp = first; temp != null; temp = temp.getNext())
			System.out.print(temp.getData() + " -> ");
		System.out.println();
	}
	
	public void add(E e){
		SingleNode<E> l = last;
		SingleNode<E> newNode = new SingleNode<E>(e, null);
		if(l == null)
			first = last = newNode;
		else{
			l.setNext(newNode);
			last = newNode;
		}
		size++;
		
	}
	
	public void addFirst(E e){
		SingleNode<E> f = first;
		SingleNode<E> newNode = new SingleNode<E>(e, null);
		if(f == null)
			first = last = newNode;
		else{
			newNode.setNext(f);
			first = newNode;
		}
		
		size++;
	}
	
	public void append(E e){
		add(e);
	}
	
	/**
	 * Delete a node present in the list.
	 * If not present then return false else return true.
	 */
	public boolean deleteNode(E e){
		SingleNode<E> prev = null, temp = first;		
		
		if(temp.getData() == e){
			first = first.getNext();
			return true;
		}
		
		for(;temp != null && !temp.equalsData(e); temp = temp.getNext()){
			prev = temp;
		}
		
		if(prev == null){
			System.out.println("Node not found");
			return false;
		}
		
		prev.setNext(prev.getNext().getNext());
		return true;
	}

	
	public boolean deleteNodeAtPosition(Integer position){
		if(position > size)
			return false;
		if(position == 1){
			first = first.getNext();
			return true;
		}
		
		SingleNode<E> temp = first;
		for(int i=1;i<position-1; i++, temp = temp.getNext());
		temp.setNext(temp.getNext().getNext());
		return true;
	}
	
	
	public boolean swapNodes(E e1, E e2){
		return false;
	}
	
	public SingleNode<E> getFirst() {
		return first;
	}
	
	public void setFirst(SingleNode<E> first) {
		this.first = first;
	}

	public SingleNode<E> getLast() {
		return last;
	}

	public void setLast(SingleNode<E> last) {
		this.last = last;
	}
	
}
