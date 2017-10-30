package queue;

public class Node {
	public PriorityQdata data;
	public Node next;
	
	public Node() {
		this(null,null);
	}
	
	public Node(PriorityQdata data) {
		this(data,null);
	}
	
	public Node(PriorityQdata data,Node next) {
		this.data = data;
		this.next = next;
	}
}
