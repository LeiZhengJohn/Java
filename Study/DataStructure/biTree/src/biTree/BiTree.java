package biTree;

import linkQueue.LinkQueue;
import linkStack.LinkStack;

public class BiTree {

	private BiTreeNode root;

	public BiTree(){
		this.root = null;
	}
	public BiTree(BiTreeNode root){
		this.root = root;
	}

	/*递归算法*/
	public void preRootTraverse(BiTreeNode T){
		if(T != null){
			System.out.print(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}
	public void inRootTraverse(BiTreeNode T){
		if(T != null){
			inRootTraverse(T.lchild);
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}
	public void postRootTraverse(BiTreeNode T){
		if(T != null){
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}
	
	/*非递归算法*/
	public void preRootTraverse(){
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();
			S.push(T);
			while(!S.isEmpty()){
				T = (BiTreeNode) S.pop();
				System.out.print(T.data);
				while(T != null) {
					if(T.lchild != null) {
						System.out.print(T.lchild.data);
					}
					if(T.rchild != null) {
						S.push(T.rchild);
					}
					T = T.lchild;
				}
			}
		}
	}
	
	public void inRootTraverse(){
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();
			S.push(T);
			while(!S.isEmpty()){
				while(S.peek() != null) {
					S.push(((BiTreeNode) S.peek()).lchild);
				}
				S.pop();
				if(!S.isEmpty()) {
					T = (BiTreeNode) S.pop();
					System.out.print(T.data);
					S.push(T.rchild);
				}
			}
		}
	}
	
	public void postRootTraverse(){
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();
			S.push(T);
			boolean flag;
			BiTreeNode p = null;
			while(!S.isEmpty()){
				while(S.peek() != null) {
					S.push(((BiTreeNode) S.peek()).lchild);
				}
				S.pop();
				while(!S.isEmpty()){
					T = (BiTreeNode) S.peek();
					if(T.rchild == null || T.rchild == p) {
						System.out.print(T.data);
						S.pop();
						p = T;
						flag = true;
					}else {
						S.push(T.rchild);
						flag  =false;
					}
					if(!flag) {
						break;
					}
				}
			}
		}
	}
	
	/*层次遍历*/
	public String levelTraverse() {
		String result = "";
		BiTreeNode T  = root;
		if(T != null) {
			LinkQueue L = new LinkQueue();
			L.offer(T);
			while(!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				result += T.data;
				if(T.lchild != null) {
					L.offer(T.lchild);
				}
				if(T.rchild != null) {
					L.offer(T.rchild);
				}
			}
		}
		return result;
	}
	
	/*查找算法*/
	public BiTreeNode searchNode(BiTreeNode T,Object o) {
		if(T != null) {
			if(T.data.equals(o)) {
				return T;
			}else {
				BiTreeNode lresult = searchNode(T.lchild, o);
				return lresult != null ? lresult : searchNode(T.rchild, o);
			}
		}
		return null;
	}
	
	/*结点个数*/
	/*层次*/
	public int countNodeLevel(BiTreeNode T) {
		int count = 0;
		if(T != null) {
			LinkQueue L = new LinkQueue();
			L.offer(T);
			while(!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				++count;
				if(T.lchild != null) {
					L.offer(T.lchild);
				}
				if(T.rchild != null) {
					L.offer(T.rchild);
				}
			}
		}
		return count;
	}
	/*递归*/
	public int countNodeD(BiTreeNode T) {
		if(T !=null) {
			return countNodeD(T.lchild) + countNodeD(T.rchild) + 1;
		}else {
			return 0;
		}
	}
	
	/*深度计算*/
	public int getDepth(BiTreeNode T) {
		if(T != null) {
			int lDepth = getDepth(T.lchild);
			int rDepth = getDepth(T.rchild);
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
		return 0;
	}
	
	/*是否相等*/
	public boolean isEqual(BiTreeNode T1,BiTreeNode T2) {
		if(T1 == null && T2 == null) {
			return true;
		}
		if(T1 != null && T2 != null) {
			if(T1.data.equals(T2.data)) {
				if(isEqual(T1.lchild, T2.lchild) && isEqual(T1.rchild, T2.rchild)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/*建立树*/
	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count){
		if (count > 0) {
			char r = preOrder.charAt(preIndex);
			int i = 0;
			for (; i < count; i++) {
				if (r == inOrder.charAt(i + inIndex)) {
					break;
				}
			}
			root = new BiTreeNode(r);
			root.lchild = new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;
			root.rchild = new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;
		}
	}
	/*标明空子树*/
	private int index = 0;
	public BiTree(String preStr){
		char c = preStr.charAt(index++);
		if(c != '#'){
			root = new BiTreeNode(c);
			root.lchild = new BiTree(preStr).root;
			root.rchild = new BiTree(preStr).root;
		}else{
			root = null;
		}
	}

	public BiTree createTestTree1() {
		BiTreeNode h = new BiTreeNode('H');
		BiTreeNode g = new BiTreeNode('G');
		BiTreeNode f = new BiTreeNode('F',null,h);
		BiTreeNode e = new BiTreeNode('E',g,null);
		BiTreeNode d = new BiTreeNode('D');
		BiTreeNode c = new BiTreeNode('C',f,null);
		BiTreeNode b = new BiTreeNode('B',d,e);
		BiTreeNode a = new BiTreeNode('A',b,c);
		return new BiTree(a);
	}
	
	public static void main(String[] args) {
		BiTree biTree = new BiTree();
		BiTree testTree = biTree.createTestTree1();
		System.out.println(testTree.levelTraverse());
	}
	
}
