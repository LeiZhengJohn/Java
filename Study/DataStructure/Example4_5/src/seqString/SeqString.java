package seqString;

public class SeqString implements IString {

	private char[] strvalue;
	private int curLen;
	
	public String getString() {
		String str = "";
		for (int i = 0; i < strvalue.length; i++) {
			str += strvalue[i];
		}
		return str;
	}

	public SeqString(){
		strvalue = new char[0];
		curLen = 0;
	}

	public SeqString(String str){
		char[] tempchararray = str.toCharArray();
		strvalue = tempchararray;
		curLen = tempchararray.length;
	}

	public SeqString(char[] value){
		curLen = value.length;
		this.strvalue = new char[curLen];
		for (int i = 0; i < value.length; i++) {
			this.strvalue[i] = value[i];
		}
	}

	public void clear() {	
		this.curLen = 0;
	}

	public boolean isEmpty() {
		return curLen == 0;
	}

	public int length() {
		return curLen;
	}

	public char charAt(int index) {
		if((index < 0) || (index >= curLen)) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return strvalue[index];
	}
	
	public void allocate(int newCapacity) {
		char[] temp = strvalue;
		strvalue = new char[newCapacity];
		for (int i = 0; i < temp.length; i++) {
			strvalue[i] = temp[i];
		}
	}

	public IString substring(int begin, int end) {
		if(begin < 0) {
			throw new StringIndexOutOfBoundsException("start position should not smaller than 0");
		}
		if(end > curLen) {
			throw new StringIndexOutOfBoundsException("end position should not larger than length");
		}
		if(end < begin) {
			throw new StringIndexOutOfBoundsException("begin position should not larger than end position");
		}
		if(begin == 0 && end == curLen){
			return this;
		}else{
			char[] buffer = new char[end-begin];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = this.strvalue[i + begin];
			}
			return new SeqString(buffer);
		}
	}

	public IString insert(int offset, IString str) {
		if((offset < 0) || (offset > this.curLen)) {
			throw new StringIndexOutOfBoundsException("insert position is illegal");
		}
		int len = str.length();
		int newcount = this.curLen + len;
		if(newcount > strvalue.length){
			allocate(newcount);
		}
		for (int i = this.curLen-1; i >= offset; i--) {
			strvalue[len + i] = strvalue[i];
		}
		for (int i = 0; i < len; i++) {
			strvalue[offset + i] = str.charAt(i);
		}
		this.curLen = newcount;
		return this;
	}

	public IString delete(int begin, int end) {
		if(begin < 0) {
			throw new StringIndexOutOfBoundsException("start position should not smaller than 0");
		}
		if(end > curLen) {
			throw new StringIndexOutOfBoundsException("end position should not larger than length");
		}
		if(end < begin) {
			throw new StringIndexOutOfBoundsException("begin position should not larger than end position");
		}
		for (int i = 0; i < curLen-end; i++) {
			strvalue[begin+i] = strvalue[end+i];
		}
		curLen = curLen - (end-begin);
		return this;
	}

	public IString concat(SeqString str) {
		insert(this.curLen, str);
		return this;
	}

	public int compareTo(SeqString str) {
		int len1 = this.curLen;
		int len2 = str.curLen;
		int n = Math.min(len1,len2);
		char[] s1 = this.strvalue;
		char[] s2 = str.strvalue;
		int k = 0;
		while(k < n){
			char ch1 = s1[k];
			char ch2 = s2[k];
			if(ch1 != ch2){
				return ch1 - ch2;
			}
			k++;
		}
		return len1 - len2;
	}

	public int indexOf_BF(IString str, int start) {
		if(this != null && str != null && str.length() > 0 && this.length() >= str.length()){
			int slen = this.length();
			int tlen = str.length();
			int i = start;
			int j = 0;
			while((i < slen) && (j < tlen)){
				if(this.charAt(i) == str.charAt(j)){
					i++;
					j++;
				}else{
					i = i-j+1;
					j = 0;
				}
			}
			if(j >= str.length()){
				return i-tlen;
			}else{
				return -1;
			}
		}
		return -1;
	}

	private int[] getNext(IString str){
		int[] next = new int[str.length()];
		int j = 0;
		int k = -1;
		next[j] = k;
		while(j < str.length()-1){
			if(k == -1 || str.charAt(j) == str.charAt(k)){
				j++;
				k++;
				if(str.charAt(j) != str.charAt(k)) {
					next[j] = k;
				}else {
					next[j] = next[k];
				}
			}else{
				k = next[k];
			}
		}
		return next;
	}
	
	public int indexOf_KMP(IString str,int start) {
		int[] next = getNext(str);
		int i = start;
		int j = 0;
		while(i < this.length() && j < str.length()){
			if(j == -1 || this.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j < str.length()) {
			return -1;
		}else {
			return (i-str.length());
		}
	}
	
	public static void main(String[] args) {
		int re = new SeqString("aaabÖ£ÀÚ").indexOf_KMP(new SeqString("Ö£ÀÚ"), 0);
		System.out.println(re);
	}

}
