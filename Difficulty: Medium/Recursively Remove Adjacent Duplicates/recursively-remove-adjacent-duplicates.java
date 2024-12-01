//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String S = br.readLine();
            Solution ob = new Solution();

            String s = ob.removeUtil(S);
            if (s.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(s);
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeUtil(String s) {
        // Base case: if the string is empty or has only one character, return it as is
        if (s == null || s.length() <= 1) {
            return s;
        }

        // StringBuilder to construct the result
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            // Find the length of the current sequence of duplicate characters
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }

            // If the length of the sequence is 1, it means it's not a duplicate
            if (j == i + 1) {
                result.append(s.charAt(i));
            }

            // Move to the next sequence
            i = j;
        }

        // Recursively call removeUtil until no adjacent duplicates are found
        String newString = result.toString();
        if (newString.length() == s.length()) {
            return newString; // If no changes were made, return the string
        }
        return removeUtil(newString); // Otherwise, continue recursion
    }
}
