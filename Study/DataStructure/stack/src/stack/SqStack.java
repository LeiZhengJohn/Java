package stack;

public class SqStack implements Istack {

	private String[] elem ;
	private int top;
	
	public SqStack(int len) {
		top = 0;
		elem = new String[len];
	}
	
	public boolean isEmpty() {
		return top == 0;
	}

	public void push(String s) {
		elem[top++] = s;
	}

	public String pop() {
		if(isEmpty()) {
			return null;
		}else {
			return elem[--top];
		}
	}

}
