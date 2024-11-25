//{ Driver Code Starts
// Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int sizeOfStack = sc.nextInt();
            Stack<Integer> myStack = new Stack<>();

            // adding elements to the stack
            for (int i = 0; i < sizeOfStack; i++) {
                int x = sc.nextInt();
                myStack.push(x);
            }
            Solution obj = new Solution();
            obj.deleteMid(myStack, sizeOfStack);

            while (!myStack.isEmpty()) {
                System.out.print(myStack.peek() + " ");
                myStack.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to delete the middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // Calculate the index of the middle element
        int midIndex = sizeOfStack / 2;
        // Call the recursive helper function
        deleteAtIndex(s, midIndex);
    }
    
    
    private void deleteAtIndex(Stack<Integer> s, int midIndex) {
        // Base case: if we've reached the index to delete
        if (midIndex == 0) {
            s.pop();  // Remove the middle element
            return;
        }
        
        // Pop the top element
        int topElement = s.pop();
        // Recursive call to delete the element at the next index
        deleteAtIndex(s, midIndex - 1);
        // Push the popped element back onto the stack only occur after base case is reached 
        s.push(topElement);
    }
}
