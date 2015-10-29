package Euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AnagramicSquares {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	List<List<String>> ans_set = new ArrayList<List<String>>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        double init = Math.pow(10.0 ,n) - 1;
        double min = Math.pow(10.0,n-1);
        
        for(double i = init;i > min-1;i--)
        {
            double sqrt = Math.sqrt(i);
            
            //shud be a integer
            if(sqrt % 1 == 0)
            {
                //chk for perfect sqrt in its anagram except leading zeroes
            	List<String> li = check(String.valueOf((int)i));
                if(li != null)
                { 
                	ans_set.add(li);
                }
             }
          }
        
        int max_index = 0;
        int maxSize = 0;
        for(int i=0;i < ans_set.size(); i++){
        	List<String> li = ans_set.get(i);
        	int size = li.size();
        	
        	if(size > maxSize){ 
        		maxSize = size;
        		max_index = i;
        	}
        }
        
        System.out.println(ans_set.get(max_index).get(0));
        
      }
            
    public static List<String> check(String val)
    {       
        int n = val.length();
        List<String> li = new ArrayList<String>();
        
        for(int i = 0; i < n; i++)
        {
            String initialLetter = String.valueOf(val.charAt(i));
            if(!initialLetter.equals("0")){         	
                permute(initialLetter, val.substring(0,i)+val.substring(i+1,n),li);
            }
        }
        
        if(li.size() == 1) return null;
        else {
        	return li;
        }
    }
    
    public static void permute(String part, String rem,List<String> li)
    {
        //add only those permutations which math squares i.e it has a square root integer
            if(rem.equals("")){
                int ans = Integer.valueOf(part);
                //check for decimal values 
                if(Math.sqrt(ans) % 1 == 0) {                	                	
                	//check if the number is already present in the list for we dont want repetitions i.e 7744 , 7744 
                	if(checkNoRepeatExists(part,li))
                		li.add(part);               
                }
            }
        
        int n = rem.length();
        for(int i=0;i<n;i++){
            permute(part+String.valueOf(rem.charAt(i)), rem.substring(0,i)+rem.substring(i+1,n),li);
        }        
    }

	private static boolean checkNoRepeatExists(String part, List<String> li) {
		// TODO Auto-generated method stub
		for(String str : li){
			if(str.equals(part)) return false;
		}
		
		return true;
	}
}
