//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            if (ans.length() == 0) {
                System.out.println("\"\"");
            } else {
                System.out.println(ans);
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String s1, String s2) {
        // code here
        if (s2 == null || s1 == null || s1.length() < s2.length()) {
            return "";
        }

        int n = s1.length();
        int m = s2.length();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;

       
        while (right < n) {
           
            int i = left, j = 0;
            while (i <= right && j < m) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                i++;
            }
            
          
            if (j == m) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
              
                left++;
            } else {
               
                right++;
            }
        }

       
        return minStart == -1 ? "" : s1.substring(minStart, minStart + minLen);
    }
}
