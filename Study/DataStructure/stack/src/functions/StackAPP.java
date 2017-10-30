package functions;

import stack.SqStack;

public class StackAPP {
	
	private final int LEFT = 0;
	private final int RIGHT = 1;
	private final int OTHERS = 2;
	
	public int verifyFlag(String str) {
		if("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)) {
			return LEFT;
		}else if(")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)) {
			return RIGHT;
		}else {
			return OTHERS;
		}
	}
	
	public boolean myMatches(String str1,String str2) {
		if(("(".equals(str1) && ")".equals(str2)) || ("[".equals(str1) && "]".equals(str2)) || ("{".equals(str1) && "}".equals(str2)) || ("/*".equals(str1) && "*/".equals(str2))) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isLegal(String str) {
		SqStack s = new SqStack(str.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			String t = String.valueOf(c);
			if((i != str.length()) &&(('/' == c && '*' == str.charAt(i+1)) || ('*' == c && '/' == str.charAt(i+1)))){
				t = t.concat(String.valueOf(str.charAt(i+1)));
				++i;
			}
			if(verifyFlag(t) == LEFT) {
				s.push(t);
			}else if(verifyFlag(t) == RIGHT) {
				if(s.isEmpty() || !myMatches(s.pop(), t)) {
					return false;
				}
			}
		}
		if(!s.isEmpty()) {
			return false;
		}
		return true;
	}
}
