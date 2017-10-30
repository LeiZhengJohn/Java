package linkQueue;

public interface Iqueue {
	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek();
	public void offer(Object o);
	public Object poll();
}
