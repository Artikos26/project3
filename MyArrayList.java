package todolist;

public class MyArrayList<E> {
	
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}
	
	public void remove(int index) {
		checkIndex(index);
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		}
		elements[--size] = null; // Let GC do its work
    }
	
	public int size() {
		return size;
	}
	
	private void ensureCapacity() {
		int newSize = elements.length * 2;
		Object[] newElements = new Object[newSize];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	public void add(E element) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = element;
	}
	
	public void set(int index, E element) {
		checkIndex(index);
		elements[index] = element;
	}
}
