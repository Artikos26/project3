package todolist;

public class MyStack {
	
	private UndoAction[] elements;
	private int top;
	private static final int CAPACITY = 100;
	
	public MyStack() {
		elements = new UndoAction[CAPACITY];
		top = -1;
	}
	
	public void push(UndoAction action) {
		if (top < CAPACITY - 1) {
			elements[++top] = action;
		}
	}
	
	public UndoAction pop() {
		if (isEmpty()) {
			return null;
		}
		return elements[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}
