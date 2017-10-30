package queue;

public interface Iqueue {
	public boolean isEmpty();
	public void offer(PriorityQdata data);
	public PriorityQdata poll();
}
