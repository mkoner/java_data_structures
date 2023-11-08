package java_data_structures.linked_list;

public class Test {

	public static void main(String[] args) {
		User user1 = new User("Mamadou", "Kone");
		User user2 = new User("Ibrahim", "Kone");
		User user3 = new User("Ali", "Cisse");
		User user4 = new User("Anna", "Cisse");
		SingleLinkedList list1 = new SingleLinkedList();
		list1.insertEnd(user1);
		list1.insertBegin(user2);
		list1.insertPosition(1, user3);
		list1.insertPosition(2, user4);
		list1.printList();
		System.out.println("=====================");
		list1.deleteEnd();
		list1.printList();
		System.out.println("=====================");
		list1.deleteBegin();
		list1.printList();
		System.out.println("=====================");
		list1.insertBegin(user2);
		list1.insertEnd(user1);
		list1.printList();
		System.out.println("=====================");
		list1.deletePosition(2);
		list1.printList();
	}

}
