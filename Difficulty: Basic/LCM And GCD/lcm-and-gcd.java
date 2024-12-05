//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int a;
            a = Integer.parseInt(br.readLine());

            int b;
            b = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int[] ans = obj.lcmAndGcd(a, b);
            System.out.println(ans[0] + " " + ans[1]);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int gcd(int a, int b) {
        // Compute GCD using Euclid's algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int[] lcmAndGcd(int a, int b) {
        // Compute GCD
        int gcd = gcd(a, b);
        
        // Compute LCM using the formula LCM * GCD = a * b
        int lcm = (a / gcd) * b; // Avoid overflow by dividing first
        
        return new int[]{lcm, gcd};
    }
}


//{ Driver Code Starts.

// } Driver Code Ends