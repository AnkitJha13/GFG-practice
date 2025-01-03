//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        if (s == null || s.length() == 0 || k == 0) {
            return -1;
        }
        
        int left = 0, right = 0, maxlen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(right < s.length()){
            
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                
                left++;
            }
            
            if(map.size() == k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            
            right++;
            
        }
        
        return maxlen;
    }
}