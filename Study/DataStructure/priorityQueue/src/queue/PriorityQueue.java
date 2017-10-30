package queue;

public class PriorityQueue implements Iqueue {
	private Node font;
	private Node rear;
	private int curLen;
	
	public PriorityQueue() {
		font = rear = null;
		curLen = 0;
	}
	
	public boolean isEmpty() {
		return curLen == 0;
	}
	
	public void offer(PriorityQdata data) {
		Node s = new Node(data);
		if(isEmpty()) {
			font = rear = s;
			curLen = 1;
		}else {
			Node p = font;
			Node q = font;
			while(p != null && data.priority >= p.data.priority) {
				q = p;
				p = p.next;
			}
			if(p == null) {
				rear.next = s;
				rear = s;
			}else if(p == font) {
				s.next = font;
				font = s;
			}else {
				q.next = s;
				s.next = p;
			}
			curLen++;
		}
	}
	
	public PriorityQdata poll() {
		if(isEmpty()) {
			return null;
		}else {
			Node p = font;
			font = p.next;
			curLen--;
			return p.data;
		}
	}
}
