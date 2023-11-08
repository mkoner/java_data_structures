package java_data_structures.linked_list;

public class Test {

	public static void main(String[] args) {
		User user1 = new User("Mamadou", "Kone");
		User user2 = new User("Ibrahim", "Kone");
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertEnd(user1);
		list1.insertBegin(user2);
		list1.printList();
	}

}
