package Trees;

import CTCILibrary.TreeNode;

public class HeightOfTree {

	public HeightOfTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Question
	 * The height of a binary tree is the number of nodes on the largest path from root to any leaf. You are given a pointer to the root of a binary tree. Return the height of the tree.
You only have to complete the function.

Input Format

You are given a function,

int height_of_bt(node * root)
{

}

Output Format

Return a single value equal to the height of the binary tree.

Sample Input

     3
   /   \
  5     2
 / \    /
1   4  6
      /
     7

Sample Output

4

Explanation

The maximum length root to leaf path is 3->2->6->7. There are 4 nodes in this path. Therefore the height of the binary tree = 4.
-----------------------------------------------------
	 */
   /*    
    class Node 
       int data;
       Node left;
       Node right;
   */	
/*
 * do a post order traversal and send the max height returned on both left and right and return it height+1;
 */
   private int height(TreeNode root)
    {
       if(root == null) return 0;
       
         int leftH = height(root.left);
         int rightH = height(root.right);
         
         if(leftH > rightH) return leftH+1;
         else return rightH+1;
    }
}
