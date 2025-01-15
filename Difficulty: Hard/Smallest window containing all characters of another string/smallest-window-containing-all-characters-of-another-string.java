//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        scan.nextLine(); // Consume the newline character after the integer input

        while (test > 0) {
            String s1 = scan.nextLine(); // Read first string on a new line
            String s2 = scan.nextLine(); // Read second string on a new line

            Solution obj = new Solution();
            String str = obj.smallestWindow(s1, s2);

            if (str.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(str);
            }
            // System.out.println("~");
            test--;
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s1, String s2) {
        // Your code here
        if(s2 == null || s1 == null || s1.length() < s2.length()){
            return "";
        }
        
        HashMap<Character, Integer> s2Count = new HashMap<>();
        for(char c : s2.toCharArray()){
            s2Count.put(c, s2Count.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int required = s2Count.size();
        int matched = 0;
        int minlen = Integer.MAX_VALUE;
        int minStart = 0;
        
        HashMap<Character, Integer> s1Count = new HashMap<>();
        while(right < s1.length()){
            char rightChar = s1.charAt(right);
            
            s1Count.put(rightChar, s1Count.getOrDefault(rightChar, 0) + 1);
            
            if(s2Count.containsKey(rightChar) &&
                  s1Count.get(rightChar).equals(s2Count.get(rightChar))){
                      matched++;
                  }
                  
                  while(matched == required){
                      if(minlen > right-left+1){
                          minlen = right-left+1;
                          minStart = left;
                      }
                      
                      char leftChar = s1.charAt(left);
                      s1Count.put(leftChar, s1Count.get(leftChar) - 1);
                      
                      if(s2Count.containsKey(leftChar) 
                             && s1Count.get(leftChar) < s2Count.get(leftChar)){
                                 matched--;
                             }
                             
                             left++;
                  }
                  
                  right++;
        }
        
        return minlen == Integer.MAX_VALUE ? "" : s1.substring(minStart, minStart + minlen);
    }
}