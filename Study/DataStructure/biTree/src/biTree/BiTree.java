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

	/*µ›πÈÀ„∑®*/
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
	
	/*∑«µ›πÈÀ„∑®*/
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
	
	/*≤„¥Œ±È¿˙*/
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
