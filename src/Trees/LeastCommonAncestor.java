package Trees;

public class LeastCommonAncestor {

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

	 /* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	    
	    */
/*
 * O(n) traversal is minimum donw twice. worst case done height of LCA from node times.
 * Scalability Issue
 */
	static Node lca(Node root,int v1,int v2)
	 {
	    if(root == null) return null;
	    
	    boolean isRight_v1 = false,isRight_v2 = false;
	    
	    boolean isLeft_v1 = isPresent(root.left,v1);
	    if(!isLeft_v1)isRight_v1 = isPresent(root.right,v1);
	    
	    boolean isLeft_v2 = isPresent(root.left,v2);
	    if(!isLeft_v2) isRight_v2 = isPresent(root.right, v2);
	    
	    if(isLeft_v1 && isLeft_v2) return lca(root.left,v1,v2);    
	    else if(isRight_v1 && isRight_v2) return lca(root.right,v1,v2);
	    else if((isLeft_v1 || isLeft_v2) && (isRight_v1 || isRight_v2)) return root;
	     
	    if(root.data == v1 && (isRight_v2 || isLeft_v2))return root;
	    if(root.data == v2 && (isRight_v1 || isLeft_v1)) return root;
	        return null;
	 }

	static boolean isPresent(Node root, int v1)
	{
	    if(root == null) return false;
	   
	    if(root.data == v1)return true;
	    else
	    return (isPresent(root.left, v1) || isPresent(root.right, v1));   
	}

}
