/** COS Project 3 - @author Calvin Johnson */

package todolist;

public class MyQueue {
	
	private Task[] elements;
	private int front;
	private int rear;
	private int size;
	private static final int CAPACITY = 100;
	
	public MyQueue() {
		elements = new Task[CAPACITY];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	// Add task to the back
	public void enqueue(Task task) {
		if (size < CAPACITY) {
			rear = (rear + 1) % CAPACITY;
			elements[rear] = task;
			size++;
		}
	}
	
	// Remove task from the front
	public Task dequeue() {
		if (isEmpty()) return null;
		Task task = elements[front];
		front = (front + 1) % CAPACITY;
		size--;
		return task;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Task peek() {
		if (isEmpty()) return null;
		return elements[front];
	}
}
