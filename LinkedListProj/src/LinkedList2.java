import java.util.AbstractList;

public class LinkedList2<T> extends AbstractList<T> {

	private Node head;
	
	private class Node {
		
		private Node next;
		private T info;
		
		public Node(T info) {
			
			this.info = info;
			
		}
		
		public Node (T info, Node next) {
			
			this.next = next;
			this.info = info;
			
		}
		
	}
	
	public boolean add(T info) {
		
		if (head == null) {
			
			head = new Node(info);
			return true;
			
		}
		
		Node curr = head;
		
		while (curr.next != null) {
			
			curr = curr.next;
			
		}
		
		curr.next = new Node(info);
		
		return true;
		
	}
	
	public boolean addIndex(int i, T info) {
		
		if (head == null) {
			
			head = new Node(info);
			return true;
			
		}
		
		Node curr = head;
		Node prev = null;
		
		int index = 0;
		
		while (index < i && curr.next != null) {
			
			prev = curr;
			curr = curr.next;
			
			index++;
			
		}
		
		Node temp = new Node(info);
		
		if (i == 0) {
			
			temp.next = head;
			head = temp;
			
			return true;
			
		}
		
		temp.next = curr;
		prev.next = temp;
		
		return true;
		
	}
	
	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		Node curr = head;
		
		for (int i = 0; i < index; i++) {
			
			curr = curr.next;
			
		}
		
		return curr.info;
		
	}
	
	// index must be within our list
	public T remove (int index) {
		
		Node curr = head;
		
		for (int i = 0; i < index-1; i++) {
			
			curr = curr.next;
			
		}
		
		Node temp = curr.next;
		curr.next = curr.next.next;
		
		return temp.info;
		
	}

	@Override
	public int size() {

		int size = 0;
		
		Node curr = head;
		
		while(curr.next != null) {
			
			curr = curr.next;
			size++;
			
		}
		
		return size;
	}
	
	public String toString() {
		
		if (size() == 0) return "[ ]";
		String output = "[";
		Node curr = head;
		while (curr != null) {
			output += curr.info.toString() + ", ";
			curr = curr.next;
		}
		return output.substring(0,output.length()-2) +"]";
		
	}

	public static void main(String[] args) {
		
		LinkedList2<String> myList = new LinkedList2<String>();
		
		myList.add("hi");
		myList.add("hello");
		myList.add("hi there");
		myList.addIndex(1, "hey");
		myList.remove(2);
		System.out.println(myList);
		System.out.println(myList.size());
		System.out.println(myList.get(2));
		
	}
	
}
