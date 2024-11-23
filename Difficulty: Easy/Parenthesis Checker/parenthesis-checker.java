//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Push opening brackets onto the stack
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } 
            else {
                // If the stack is empty, no matching opening bracket
                if(st.isEmpty()) {
                    return false; // No matching opening bracket
                }

                // Check for matching pair of brackets
                if((st.peek() == '(' && ch == ')') || 
                   (st.peek() == '[' && ch == ']') || 
                   (st.peek() == '{' && ch == '}')) {
                    st.pop(); // Pop the matching opening bracket
                } 
                else {
                    return false; // Unmatched brackets
                }
            }
        }

        // If the stack is empty, all opening brackets have been matched
        return st.isEmpty();
    }
}

