//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!seen.contains(ch)) {  // If character is not seen before
                ans.append(ch);        // Add it to result
                seen.add(ch);          // Mark it as seen
            }
        }
        
        return ans.toString();
    }
}