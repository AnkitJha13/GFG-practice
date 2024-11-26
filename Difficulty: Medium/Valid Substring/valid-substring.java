//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initial index before the string
        int maxLen = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {
                // Push the index of the opening bracket
                stack.push(i);
            } else {
                // Pop the last unmatched opening bracket
                stack.pop();

                if (stack.isEmpty()) {
                    // If the stack is empty, push the current index
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
