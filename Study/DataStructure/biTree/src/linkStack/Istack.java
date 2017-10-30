package linkStack;

public interface Istack {
	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek();
	public void push(Object o);
	public Object pop(); 
}
