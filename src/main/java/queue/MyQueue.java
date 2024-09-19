package queue;

public class MyQueue {
int size, front, rear;
int[] elements;

public MyQueue(int size) {
	super();
	this.size = size;
	this.elements = new int[size];
	this.front = -1;
	this.rear = -1;
}

public void insert(int element) {
	if(isFull())
		return;
	if(front==-1)
		front = 0;
	rear ++;
	elements[rear] = element;
}

public int delete() {
	 if(isEmpty())
		 return -1;
	 int deletedElement = elements[front];
	 if(front==rear && !isEmpty()) {
		 front = -1;
		 rear = -1;
	 }
	 else
		 front ++;
	 return deletedElement;
}

public void display() {
	for(int i=front; i<=rear; i++)
		System.out.println(elements[i] + " ");
}

private boolean isFull() {
	return rear == size -1;
}

private boolean isEmpty() {
	return front == -1;
}
}
