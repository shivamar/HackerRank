package countercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CounterTerrorist {

	/*
	 * Problem Statement

Time is running out. You have a final match to play as a counter terrorist. You have N players each having a distinct ID from 1 to N. You have to choose some players on your team from these N players such that no two chosen players have consecutive numbers (as they tend to kill each other). Also you definitely have to choose some K players whose numbers are given. They are the snipers. Find the maximum number of players that you can choose.

Input Format

The first line contains 2 space-separated integers, N and K, where N is the total number of players and K is the number of players that have to be definitely in the team (the snipers).
The second line contains K space-separated integers that are the IDs of the snipers.

NOTE: There are no two snipers with consecutive numbers.

Constraints
2≤N≤2×106
1≤K≤N/2
1≤ ID of each sniper ≤N

Output Format

You need to print the maximum number of players that you can have in your team.
	 */
	public CounterTerrorist() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
   Scanner in = new Scanner(System.in);
   int N = in.nextInt();
   int K = in.nextInt();
   
   HashSet set = new HashSet();
   ArrayList<Integer> li = new ArrayList<Integer>();
   
   for(int i=1;i <= K;i++)
	   
   {
       int num = in.nextInt();
       li.add(num);
       
       set.add(num);
       set.add(num-1);
       set.add(num+1);
   }
   
   System.out.println(teamSize(N, set, li));

	}

	
	public static int teamSize(int N, HashSet set,ArrayList<Integer> li)
	{
		   for(int i=1;i <= N;i++)
		   {
		       if(set.contains(i)) continue;
		       
		       li.add(i); 
		       i++;
		   }    
		       
		   return li.size();
	}
}
