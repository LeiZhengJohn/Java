package utils;


@SuppressWarnings("unchecked")
public class MyOrderedList<T> implements MyList<T>{
	
	private T[] listElem;
	private int curLen;
	
	
	public T[] getListElem() {
		return listElem;
	}

	public void setListElem(T[] listElem) {
		this.listElem = listElem;
	}

	public int getCurLen() {
		return curLen;
	}

	public void setCurLen(int curLen) {
		this.curLen = curLen;
	}

	public MyOrderedList(int maxsize) {
		curLen = 0;
		listElem = (T[]) new Object[maxsize];
	}

	public MyOrderedList(T[] t) {
		curLen = t.length;
		listElem = t;
	}
	
	public void clear() {
		curLen = 0;
		listElem = (T[]) new Object[5];
	}
	
	public boolean isEmpty() {
		return curLen == 0;
	}

	public int length() {
		return curLen;
	}

	public T get(int i) {
		if(i  < 0 || i  > curLen-1) {
			return null;
		}else {
			return listElem[i];
		}
	}

	public int insert(int x, T j) {
		boolean flag = false;
		if(curLen == listElem.length) {
			T[] newListElem = (T[]) new Object[listElem.length*2];
			for (int i = 0; i < listElem.length; i++) {
				newListElem[i] = listElem[i];
			}
			listElem = newListElem;
			flag = true;
		}
		if(x < 0 || x > curLen) {
			return -1;
		}else {
			for (int i = curLen; i > x; i--) {
				listElem[i] = listElem[i-1];
			}
			listElem[x] = j;
			curLen++;
			if(flag) {
				return 0;
			}else {
				return 1;
			}
		}
	}

	public int remove(int x) {
		boolean flag = false;
		if(curLen < listElem.length/2) {
			T[] newListElem = (T[]) new Object[listElem.length/2];
			for (int i = 0; i < newListElem.length; i++) {
				newListElem[i] = listElem[i];
			}
			listElem = newListElem;
			flag = true;
		}
		if(x < 0 || x > curLen) {
			return -1;
		}else {
			for (int i = x; i < curLen-1; i++) {
				listElem[i] = listElem[i+1];
			}
			curLen--;
			if(flag) {
				return 1;
			}else {
				return 0;
			}
		}
	}

	public int indexOf(String j) {
		int i = 0;
		while(i < curLen && !listElem[i].toString().equals(j)) {
			i++;
		}
		if(i < curLen) {
			return i;
		}else {
			return -1;
		}
	}

	public String display() {
		String contain = "";
		for(int i = 0;i < curLen;i++) {
			contain += (listElem[i] + " ,");
		}
		return contain;
	}

}
