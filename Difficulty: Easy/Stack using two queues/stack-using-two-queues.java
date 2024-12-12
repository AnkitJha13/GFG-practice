//{ Driver Code Starts
import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends



class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    if(!q1.isEmpty()){
	        q1.add(a);
	    }
	    else{
	        q2.add(a);
	    }
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    if(isEmpty()){
	        return -1;
	    }
	    
	    int top = -1;
	    if(!q1.isEmpty()){
	        while(!q1.isEmpty()){
	            top = q1.remove();
	            if(q1.isEmpty()){
	                break;
	            }
	            q2.add(top);
	        }
	    }
	    else{
	        while(!q2.isEmpty()){
	            top = q2.remove();
	            if(q2.isEmpty()){
	                break;
	            }
	            q1.add(top);
	        }
	    }
	    
	    return top;
    }
    
    public boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty();
    }
	
}

