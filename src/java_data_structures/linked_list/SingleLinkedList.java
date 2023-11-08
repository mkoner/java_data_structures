package java_data_structures.linked_list;

public class SingleLinkedList {
	Node head = null;
	
	public void insertEnd(User user) {
		Node node = new Node();
		node.user = user;
		node.next = null;
		if(head == null)
			head=node;
		else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
		}
	}
	
	public void insertBegin(User user) {
		Node node = new Node();
		node.user = user;
		node.next = head;
		head = node;
	}
	
	public void insertPosition(int position, User user) {
		Node node = new Node();
		node.user = user;
		Node currentNode = head;
		for(int i=0; i<position - 1; i++) {
			currentNode = currentNode.next;
		}
		node.next = currentNode.next;
		currentNode.next = node;
	}
	
	public void deleteEnd() {
		Node currentNode = head;
		Node prevNode = null;
		while(currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			
		}
		prevNode.next = null;
		currentNode = null;
	}
	
	public void deleteBegin() {
		Node toBeDeleted = head;
		head = head.next;
		toBeDeleted = null;
	}
	
	public void deletePosition(int position) {
		if(position == 0)
			deleteBegin();
		else {
			Node currentNode = head;
			for(int i=0; i<position - 1; i++) {
				currentNode = currentNode.next;
			}
			Node toBeDeleted = currentNode.next;
			currentNode.next = toBeDeleted.next;
			toBeDeleted = null;
		}
	}
	
	public void printList() {
		Node currentNode = head;
		while(currentNode.next != null) {
			System.out.println(currentNode.user);
			currentNode = currentNode.next;
		}
		System.out.println(currentNode.user);
	}
}
