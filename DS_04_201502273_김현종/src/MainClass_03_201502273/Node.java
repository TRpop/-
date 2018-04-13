package MainClass_03_201502273;

public class Node<T> {
	private Node<T> next;
	private T value;

	public Node() {
		this.next = null;
	}

	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	public Node getNext() {
		return this.next;
	}

	public boolean setNext(Node next) {
		this.next = next;
		return true;
	}

	public T getValue() {
		return this.value;
	}

	public boolean setValue(T value) {
		this.value = value;
		return true;
	}
}
