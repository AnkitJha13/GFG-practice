//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
     public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Handle closing parenthesis
            if (ch == ')') {
                int operatorCount = 0;
                
                // Pop until finding the opening parenthesis '('
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorCount++;
                    }
                }
                
                // If no operator found, it's redundant
                if (operatorCount == 0) {
                    return 1;
                }
                
                // Pop the opening parenthesis '('
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // Push current character to the stack if it's not a closing parenthesis
                st.push(ch);
            }
        }
        
        return 0; // No redundancy found
    }
}
        
