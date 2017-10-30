package stack;

public class SqStack implements Istack {

	private int[] elem ;
	private int top;
	
	public SqStack(int len) {
		top = 0;
		elem = new int[len];
	}
	
	public boolean isEmpty() {
		return top == 0;
	}

	public void push(int c) {
		elem[top++] = c;
	}

	public int pop() {
		if(isEmpty()) {
			return 0;
		}else {
			return elem[--top];
		}
	}

}
