package utils;

public class Node {
	public double down;
	public int up;
	public Node next;
	
	public Node() {
		this(0,0,null);
	}
	
	public Node(double down,int up) {
		this(down,up,null);
	}
	
	public Node(double down,int up,Node next) {
		this.down = down;
		this.up = up;
		this.next = next;
	}
}
