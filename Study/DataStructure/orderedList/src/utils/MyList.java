package utils;

public interface MyList<T> {

	public void clear();
	public boolean isEmpty();
	public int length();
	public T get(int i);
	public int insert(int x,T j);
	public int remove(int i);
	public int indexOf(String j);
	public String display();
}
