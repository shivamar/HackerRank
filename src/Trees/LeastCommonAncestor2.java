/**
 * 
 */
package Trees;

/**
 * @author Shiva
 *
 */

public class LeastCommonAncestor2 {

	/**
	 * 
	 */
	public LeastCommonAncestor2() {
		// TODO Auto-generated constructor stub
	}

	class Node
	{		
		int data;
		Node left;
		Node right;
		
		public Node()
		{
		}
		
		public Node(int value) {
			data = value;		
		}		
	}

	//post order traversal single 0(n)
	/*
	 * best way to do it. Time Coomplexity --> O(n)
	 * Since we need to check if each root is the lca if it has v1,v2 on either sides,
	 * Post order traversal(traversal on left, traversal on right and then check the root)
	 * is best suited wherein we check the two sides and if present 
	 * on both we return the current node as the answer root.
	 * 
	 * Base case - present root value equals n 
	 */
	static Node lca(Node root, int v1, int v2)
	{
	  if(root == null) return null;
	  if(root.data == v1 || root.data == v2) return root;
	  Node isLeft =  lca(root.left, v1, v2);
	  Node isRight = lca(root.right, v1, v2);
	    
	  if(isLeft != null && isRight != null) return root;
	  if(isLeft != null) return isLeft;
	  if(isRight != null) return isRight;
	    
	    return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
