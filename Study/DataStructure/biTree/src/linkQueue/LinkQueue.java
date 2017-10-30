package linkQueue;

public class LinkQueue implements Iqueue {

	private Node front;
	private Node rear;
	private int length;

	public LinkQueue(){
		front = rear = null;
	}

	public void clear(){
		length = 0;
		front = rear = null;
	}

	public boolean isEmpty(){
		return length == 0;
	}

	public int length(){
		return length;
	}

	public Object peek(){
		if(!isEmpty()){
			return front.data;
		}else{
			return null;
		}
	}

	public void offer(Object o){
		Node p = new Node(o);
		if(!isEmpty()){
			rear.next = p;
			rear = p;
		}else{
			front = rear = p;
		}
		length++;
	}

	public Object poll(){
		if(!isEmpty()){
			Node p = front;
			front = front.next;
			if(p == rear){
				rear = null;
			}
			length--;
			return p.data;
		}else{
			return null;
		}
	}

}
