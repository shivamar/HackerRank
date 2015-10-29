package Trees;

import CTCILibrary.*;

public class TopViewOfBinaryTree {

	public TopViewOfBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
You only have to complete the function.
For example :

     3
   /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8
Top View : 1 -> 5 -> 3 -> 2 -> 7

	 */
	/*
	   class Node 
	       int data;
	       Node left;
	       Node right;
	*/
	static void top_view(TreeNode root)
	{
	    leftFromBottom(root.left);
	    System.out.print(root.value+" ");
	    rightFromBottom(root.right);
	}

	static void leftFromBottom(TreeNode root)
	{
	    if(root == null) return;
	    leftFromBottom(root.left);
	    System.out.print(root.value+" ");
	}

	static void rightFromBottom(TreeNode root)
	{
	    if(root == null) return;
	    
	    System.out.print(root.value+" ");
	    rightFromBottom(root.right);
	}

	public static void main(String[] args)
	{
		TreeNode n = new TreeNode(5);

		n.add(2);
		n.add(3);		
		n.add(1);		
		n.add(6);
		n.add(8);
		n.add(7);
			
		top_view(n);		
		
		
	}
}
