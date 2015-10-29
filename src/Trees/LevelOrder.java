package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.InsertBSTNode.Node;

public class LevelOrder {

	public LevelOrder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   void LevelOrder(Node root)
    {
      Queue<Node> q = new LinkedList<Node>();
       if(root != null) q.add(root);
       
       while(!q.isEmpty())
       {
         Node node = q.remove();
         System.out.print(node.data+" ");    
         if(node.left != null)
            q.add(node.left);  
         if(node.right != null)
             q.add(node.right);
       }
    }

}
