//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
        {
            //add code here.
            if(isEmpty(s)){
                return -1;
            }
            
            return s.pop();
            
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           int min = Integer.MAX_VALUE;
           
           for(Integer element : s){
               if(element < min){
                   min = element;
               }
           }
           
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           
           return s.isEmpty();
	}
}