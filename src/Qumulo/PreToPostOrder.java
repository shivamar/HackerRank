package Qumulo;
import java.util.*;
import java.lang.*;
import java.io.*;


public class PreToPostOrder {
    
	
	public static void PrintPostOrder(int root,int[] left,int[] right)
{
    if(left != null && left.length > 0){
        int rootL = left[0];
        int rightStarts = findBiggerIndex(left);
        
        PrintPostOrder(rootL,Arrays.copyOfRange(left,1,rightStarts),Arrays.copyOfRange(left,rightStarts, left.length));                
    }
    
    if(right != null && right.length > 0){
        int rootR = right[0];
        int rightStarts = findBiggerIndex(right);
        
         PrintPostOrder(rootR,Arrays.copyOfRange(right,1,rightStarts),Arrays.copyOfRange(right,rightStarts, right.length)); 
    }
    
    System.out.println(root);    
}

   public static int findBiggerIndex(int[] arr){
       int root = arr[0];
        for(int i=0; i < arr.length; i++)
        {
            if(arr[i] > root) return i;
        }
        
        return 1;
   }
   
	public static void main (String[] args) throws java.lang.Exception
	{
        
        Scanner sc = new Scanner(System.in);
        ArrayList arr_l = new ArrayList();
        
//        while(sc.hasNext()){   //getting hackerrank test cases
//            arr_l.add(sc.nextInt());
//        }
    
		// your code goes here
		int[] pre = {4,2,1,3,5};
		int rightStarts = findBiggerIndex(pre);
		
		PrintPostOrder(pre[0], Arrays.copyOfRange(pre,1,rightStarts), Arrays.copyOfRange(pre,rightStarts,pre.length));
		
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v){
		val = v;
	}
}

}