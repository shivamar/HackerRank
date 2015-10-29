package countercode;

import java.util.ArrayList;
import java.util.Scanner;

public class Imba {

	public Imba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */        
        Scanner in = new Scanner(System.in);
        //aa
        int T = in.nextInt();
        //bb
        for(int i=0;i < T;i++)
        {
            int num = in.nextInt();
            getAns(num);
        }        
    }
    
    private static void getAns(int N)
    {
        ArrayList<Integer> li = new ArrayList<Integer>();
        
       for(int i=1; i <= N;i++)
       {
           li.add(i);
       }
       
        int i = 0;
         while(i+1 < N)
         {
            int sum = li.get(i) + li.get(i+1);    
            
            if(!(sum <= N+1))
            {
               int temp = li.get(i+1);
               int prev = li.get(i);
               
               if(prev > temp) 
                {   
                swap(li, i, i-1);
                i=0;
                continue;
               }  
               li.set(i+1, prev);
               li.set(i, temp);
                
               i=0;
               continue;
            }
             else
             {
              i++;      
             }             
         } 
                
         
      for(int k:li)
          System.out.print(k+" ");   
 
      System.out.println("");
    }
    
    private static void swap(ArrayList<Integer> li, int tempPos, int prevPos)
    {
         int temp = li.get(tempPos);
         int prev = li.get(prevPos);
        
         li.set(tempPos, prev);
         li.set(prevPos, temp);
    }
}