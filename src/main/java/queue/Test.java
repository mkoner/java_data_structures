package queue;

public class Test {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.insert(10);
		queue.insert(16);
		queue.insert(1);
		queue.insert(4);
		queue.insert(29);
		queue.insert(29);
		queue.display();
	}

}
