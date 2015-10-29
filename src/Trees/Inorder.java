package Trees;

import Trees.InsertBSTNode.Node;

public class Inorder {

	public Inorder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* you only have to complete the function given below.  
	Node is defined as  

	class Node {
	    int data;
	    Node left;
	    Node right;
	}

	*/

	void Inorder(Node root) {
	    if(root == null) return;
	    Inorder(root.left);
	    System.out.print(root.data+" ");
	    Inorder(root.right);
	}


}
