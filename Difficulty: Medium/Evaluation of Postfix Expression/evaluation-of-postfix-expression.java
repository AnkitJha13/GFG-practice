//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        
        for(String c : arr){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        
        return stack.pop();
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends