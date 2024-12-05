//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    static long fibSum(long N) {
        // code here
    
       long MOD = 1000000007;
        
        // Handle base cases
        if (N == 0) return 0; 
        if (N == 1) return 1; 
        
        
        long a = 0, b = 1, sum = 1; 
        
    
        for (int i = 2; i <= N; i++) {
            long next = (a + b) % MOD; 
            sum = (sum + next) % MOD; 
            a = b;                    
            b = next;                 
        }
        
        return sum;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fibSum(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends