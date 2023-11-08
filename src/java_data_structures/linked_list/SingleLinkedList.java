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
}
