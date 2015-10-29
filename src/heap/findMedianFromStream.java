package heap;

import java.util.Scanner;
import CTCILibrary.*;

/*
 * Problem Statement

The median of a finite list of numbers can be found by arranging all the integers from lowest to highest value and picking the middle one. For example, the median of {3,3,5,9,11} is 5. If there is an even number of integers, then there is no single middle value, and the median is then usually defined to be the mean of the two middle values. For examples, the median of {3,5,7,9} is (5+7)2=6.

Given that integers are read from a data stream, find the median of elements read so far in an efficient way.

Input Format

The first line of input will contain integer N, i.e. the number of integers in the data stream.
The next N lines will contain an integer ai each in order.

Constraints
1≤N≤105
0≤ai≤105

Output Format

Print N integers, i.e. the median after each of the input. Report it with precision up to 10−1.


 */
public class findMedianFromStream {

	private static int[] arr;
	private static int currCounter = 0;
	
	public findMedianFromStream() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int len_X = sc.nextInt();
		Heap minHeap = new Heap("min",len_X);
		Heap maxHeap = new Heap("max",len_X);
		int[] firstTwo = new int[2];

		for(int i = 0; i < len_X; i ++)
		{
			int num = sc.nextInt();
			if(i==0) {
				print(num);
				firstTwo[0] = num;
			}
			else if(i==1) {
				firstTwo[1] = num;
				
				if(firstTwo[0] < firstTwo[1]) {
					maxHeap.add(firstTwo[0]);
					minHeap.add(firstTwo[1]);
				}
				else
				{
					maxHeap.add(firstTwo[1]);
					minHeap.add(firstTwo[0]);
				}				
				
				printMedian(minHeap,maxHeap);
			}
			else {
				
				int topMax = maxHeap.peekTop();
				if(num > topMax) minHeap.add(num);
				else maxHeap.add(num);
				
				printMedian(minHeap,maxHeap);
			}						
		}
		
//		
//		for(int i = 0; i < len_X; i ++)
//		{
//			int num = sc.nextInt();
//			//currCounter = i+1;
//			
//			if(i % 2 == 0)
//			 print(minHeap.add(num));
//			else
//			 print(maxHeap.add(num));
//			
//		}
////		System.out.println("removing min starts");
////		print(minHeap.removeLast());
////		print(minHeap.removeLast());
////		print(minHeap.removeLast());
////		System.out.println("removing max starts");
////		print(maxHeap.removeLast());
////		print(maxHeap.removeLast());
////		print(maxHeap.removeLast());
////		
////		
////		 print(minHeap.add(8));print(minHeap.add(5));
////		 print(maxHeap.add(5));print(maxHeap.add(8));		
	}
	
	private static void printMedian(Heap minHeap, Heap maxHeap) {
		int diff = maxHeap.count() - minHeap.count();
		
		if(diff == 1)
		{
		//print the topElement of maxHeap
			print(maxHeap.peekTop());			
		}
		else if(diff == -1)
		{
		//print the topElement of minHeap
			print(minHeap.peekTop());			
		}
		else if(diff == 0)
		{
			//print avg of extractMin,Max of two heaps
			
			print((float)(maxHeap.peekTop()+minHeap.peekTop())/ 2);
		}
		else if(diff > 1)
		{
			//extract from top of max and add it to minHeap
			int x = maxHeap.removeLast();
			minHeap.add(x);
		
			printMedian(minHeap,maxHeap);
			
		}
		else if(diff < -1)
		{
			//extract from top of min and add it to maxHeap
			int x = minHeap.removeLast();
			maxHeap.add(x);
			
			printMedian(minHeap,maxHeap);
		}		
	}

	public static void print(float x)	
	{
		System.out.println(x);
	}

	public static void print(int[] x)
	{
		for(int i : x)
		System.out.print(i);
		
		System.out.println("");
	}
	
	// 2i + 1 , 2i + 2 is the child!
	public static int[] buildMaxHeap(int x)
	{
		arr[currCounter] = x;
		if(currCounter == 1) return arr;
		
		int parent_num = currCounter / 2;
		
		do
		{
			if(arr[parent_num] < arr[currCounter]) swap(parent_num,currCounter);
			checkChild_MaxHeapProperty(parent_num);
			parent_num = parent_num / 2;
		}
		while(parent_num >= 1);
		
		return arr;
	}
	
	private static void checkChild_MaxHeapProperty(int parent_num) {
		// TODO Auto-generated method stub
		int child1 = 2 * parent_num;
		int child2 = 2 * parent_num + 1;
		
		if(arr[parent_num] < arr[child1]) swap(parent_num, child1) ;
		if(arr[parent_num] < arr[child2]) swap(parent_num, child2) ;
		
		if(arr[child1] < arr[child2]) swap(child1, child2);
	}

	private static void swap(int parent_num, int curr) {
		int temp = arr[curr];
		arr[curr] = arr[parent_num];
		arr[parent_num] = temp;		
	}

	private static float findMedian(int[] arr)
	{
		int size = currCounter;
		if(size == 1) return arr[size];			
		
		float ans = arr[size/2]+arr[(size/2) + 1] ;
		ans = ans /2;
		if(size % 2 == 0) return ans;
		else return arr[size/2 + 1];
	}
	
	public static int[] buildMinHeap(int x)
	{
		arr[currCounter] = x;
		if(currCounter == 1) return arr;
		
		int parent_num = currCounter / 2;
		
		do
		{
			if(arr[parent_num] > arr[currCounter]) swap(parent_num,currCounter);
			checkChild_MinHeapProperty(parent_num);
			parent_num = parent_num / 2;
		}
		while(parent_num >= 1);
		
		return arr;
		
	}
	
	private static void checkChild_MinHeapProperty(int parent_num) {
		// TODO Auto-generated method stub
		int child1 = 2 * parent_num;
		int child2 = 2 * parent_num + 1;
		
		if(arr[parent_num] > arr[child1]) swap(parent_num, child1) ;
		if(child2 <= currCounter)
		if(arr[parent_num] > arr[child2]) swap(parent_num, child2) ;
		
		//if(arr[child1] > arr[child2]) swap(child1, child2);
	}
}
