package linkStack;

public class LinkStack implements Istack {

	private Node top;
	int length = 0;

	public LinkStack(){
		top = null;
	}

	public void clear(){
		length = 0;
		top = null;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int length(){
		return length;
	}

	public Object peek(){
		if(!isEmpty()){
			return top.data;
		}else{
			return null;
		}
	}

	public void push(Object o) {
		Node p = new Node(o);
		p.next = top;
		top = p;
		length++;
	}

	public Object pop() {
		if(isEmpty()) {
			return null;
		}else {
			Node p = top;
			top = top.next;
			length--;
			return p.data;
		}
	}

}
