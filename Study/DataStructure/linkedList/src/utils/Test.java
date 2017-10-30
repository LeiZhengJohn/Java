package utils;

public class Test {
	public static void main(String[] args) {
		/*MyLinkedList list = new MyLinkedList();
		MyLinkedList list1 = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();
		String[] str = {"-2,1","-3,2","-4,3","-5.6,0","-3.2,2"};
		String[] str2 = {"2,1","3,2","4,3","5.6,0","3.2,2"};
		list.create(str);
		list1.create(str2);
		list2 = MyLinkedList.compile(list, list1);
		System.out.println(list.display());
		System.out.println(list1.display());
		System.out.println(list2.display());
		list2.simplify();
		System.out.println(list2.display());*/
		String str = "3.636£¬-3";
		if(str.matches("([0-9]+(.[0-9]+)?|-[0-9]+(.[0-9]+)?)(,|£¬)(0|[1-9][0-9]*|-[1-9][0-9]*)")) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		
	}
	
	
}
