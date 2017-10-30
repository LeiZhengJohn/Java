package utils;

public class MyLinkedList implements MyList {
	
	public Node head;
	public int curLen;
	
	public MyLinkedList() {
		head = new Node();
		curLen = 0;
	}

	public void create(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String[] str = args[i].split(",|£¬");
			Node node = new Node(Double.parseDouble(str[0]),Integer.parseInt(str[1]),head.next);
			head.next = node;
			curLen++;
		}
	}

	public static MyLinkedList compile(MyLinkedList A, MyLinkedList B) {
		MyLinkedList C = new MyLinkedList();
		Node p = A.head;
		Node q = B.head;
		for (int i = 0; i < A.curLen; i++) {
			p = p.next;
			Node node = new Node(p.down,p.up,C.head.next);
			C.head.next = node;
			C.curLen++;
		}
		for (int i = 0; i < B.curLen; i++) {
			q = q.next;
			Node node = new Node(q.down,q.up,C.head.next);
			C.head.next = node;
			C.curLen++;
		}
		return C;
	}

	public String display() {
		String result = "";
		Node p = head.next;
		if(Math.abs(p.down) > 1e-15) {
			if(p.up == 0) {
				result += p.down+"";
			}else if(p.up == 1) {
				result += p.down + " x";
			}else {
				result += (p.down+" x^"+p.up);
			}
		}
		
		while((p=p.next) != null) {
			String temp = "";
			if(Math.abs(p.down) > 1e-15) {
				if(p.up == 0) {
					temp += " + " + p.down+"";
				}else if(p.up == 1) {
					result += " + " + p.down + " x";
				}else {
					temp = " + " + p.down + " x^" +p.up;
				}
				result += temp;
			}
		}
		
		if(result.equals("")) {
			result = "0";
		}
		return result;
	}

	public void sort() {
		for (int i = 0; i < curLen; i++) {
			Node p = head.next;
			Node q = p.next;
			while(p != null && q != null) {
				if(p.up > q.up) {
					double tempDown = p.down;
					int tempUp = p.up;
					p.up = q.up;
					p.down = q.down;
					q.up = tempUp;
					q.down = tempDown;
				}
				p = p.next;
				q = q.next;
			}
		}		
	}

	public void simplify() {
		Node p = head.next;
		while(p != null) {
			Node q = p;
			while(q != null){
				Node o = q;
				q = o.next;
				if(q != null && q.up == p.up) {
					p.down += q.down;
					o.next = q.next;
					q = o;
					curLen--;
				}
			}
			p = p.next;
		}
	}


}
