package functions;

import stack.SqStack;

public class Example3_2 {
	public String add(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		SqStack sum = new SqStack((len1 > len2)?len1+1:len2+1);
		SqStack sq1 = new SqStack(len1);
		SqStack sq2 = new SqStack(len2);
		int extra = 0;
		for (int i = 0; i < str1.length(); i++) {
			sq1.push(Integer.parseInt(String.valueOf(str1.charAt(i))));
		}
		for (int i = 0; i < str2.length(); i++) {
			sq2.push(Integer.parseInt(String.valueOf(str2.charAt(i))));
		}
		while(!sq1.isEmpty() || !sq2.isEmpty()) {
			int x = sq1.pop() + sq2.pop() + extra;
			if(x >9) {
				extra = 1;
				x = x - 10;
			}else {
				extra = 0;
			}
			sum.push(x);
		}
		if(extra != 0) {
			sum.push(1);
		}
		StringBuffer result = new StringBuffer();
		while(!sum.isEmpty()){
			result.append(sum.pop());
		}
		return result.toString();
	}

}
