package contest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Boomerang {

    public static void main(String[] args) {
      
        
       BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
       try
       {   
         int T= Integer.parseInt(inp.readLine());
            
         for(int i=0;i<T;i++)
         {
            int n= Integer.parseInt(inp.readLine());
            //Your code goes here
             
            System.out.println(findWinner(n));
         }
       }
         catch(Exception e){}

      
    }
        
    public static Node deleteChainNext(Node tempo,Node head,int size)
    {
        //only if 2 nodes are present and head is to be the tempo
        if(head.equals(tempo) && size == 2) {
            head.next = null;
            head.tail = null;
            
            return head;
        }
        
        //if both the tempo n headd are same and size > 2, we need to delete the head and send the next node as its head and sets its tail too.
        if(head.equals(tempo) && size > 2) {
            head.next.tail = head.tail;
            head.tail.next = head.next;
            
            head = head.next;
            
            return head;
        }
        
        if(tempo.next.tail != null || tempo.next.equals(head)){
            //delete head by delinking its prev and next node
                Node temp1 = head.next;
                Node tail1 = head.tail;
                
                tail1.next = temp1;
                temp1.tail = tail1;
                //set head as the head's next node
                head = temp1;
            
            return head;
        }
        else{
            tempo.next = tempo.next.next;
            
            return head;
        }
    }
    
    public static int findWinner(int n)
    {
        Node head = new Node(1);
        
        for(int i=2;i<=n;i++)
            head.addAtTail(i);
        
        head.tail.next = head;        
        
        int size = n,chance = 0,remove = 0;
        
        while(size > 1){            
            
            if(size % 2 == 1) 
            {       
                Node tempo = head;
                int i = chance;
                while(--i > 0){
                    tempo = tempo.next;
                }
                
                head = deleteChainNext(tempo, head, size);                
            }
            else
            {
                Node tempo = head;
                remove = (size/2);
                
                int i = remove+ chance;
                while(--i > 0){
                    tempo = tempo.next;
                }
                
                head = deleteChainNext(tempo, head, size);  
                chance++;
            }
            
           size = size - 1;
        }        
        
        return head.val;
    }
}


    
    class Node
    {
        Node next;
        
        Node tail;
        
        int val = 0;
        public Node(int v){
            val = v;
        }
        
        public void addAtTail(int v){
            Node temp = new Node(v);
            if(next == null){
                this.next = temp;
                tail = temp; 
            }
            else{                
                tail.next = temp;   
                tail = temp;
            }
        }
    }

