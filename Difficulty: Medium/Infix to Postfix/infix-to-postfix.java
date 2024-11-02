//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    // Function to get the priority of operators
    public static int priority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    // Function to convert an infix expression to a postfix expression
    public static String infixToPostfix(String exp) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If it is an operand, add it to the result
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }
            // If it is an opening bracket, push it to the stack
            else if (ch == '(') {
                st.push(ch);
            }
            // If it is a closing bracket, pop until an opening bracket is found
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop(); // Remove the opening bracket
            }
            // If it is an operator
            else {
                while (!st.isEmpty() && priority(st.peek()) >= priority(ch)) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }
}
