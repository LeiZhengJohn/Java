package seqString;

public interface IString {
	public void clear();
	public boolean isEmpty();
	public int length();
	public char charAt(int index);
	public IString substring(int begin,int end);
	public IString insert(int offset,IString str);
	public IString delete(int begin,int end);
	public IString concat(SeqString str);
	public int compareTo(SeqString str);
	public int indexOf_BF(IString str,int start);	
}
