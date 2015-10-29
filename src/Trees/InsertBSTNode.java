package Trees;

import CTCILibrary.TreeNode;

public class InsertBSTNode {

	 /* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	    
	    */
	
	// TODO Auto-generated constructor stub
	class Node extends TreeNode
	{		
		int data;
		Node left;
		Node right;
		
		public Node()
		{
			
		}
		public Node(int value) {
			super(value);
			data = value;
			left = (Node) super.left;
			right = (Node)super.right;		
		}
		
	}

	static Node Insert(Node root, int value)
	{
	    if (root == null)
	       root = construct(value);    
	    else if (value < root.data){
	       root.left = Insert(root.left, value);
	    }
	    else {
	      root.right = Insert(root.right, value);
	    }
	    
	    return root;
	}

	static Node construct(int value) {
		InsertBSTNode x = new InsertBSTNode();
	    Node n = x.new Node();         //dgfhfjfkf
	    n.data = value;
	    return n;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = construct(7);
		n.right = construct(10);		
		
		Node g = Insert(n,3);
		System.out.println(g.left.data);

	}

}
