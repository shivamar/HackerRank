package Trees;

import CTCILibrary.TreeNode;

public class PostorderTraversal {

	public PostorderTraversal() {
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
	void Postorder(TreeNode root) {
	    if(root == null) return;
	    Postorder(root.left);
	    Postorder(root.right);
	    System.out.print(root.value+" ");
	}

}
