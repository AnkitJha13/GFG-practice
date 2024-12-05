//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> primeRange(int M, int N) {
        ArrayList<Integer> primesInRange = new ArrayList<>();

        // Step 1: Check for each number in the range [M, N]
        for (int num = M; num <= N; num++) {
            if (num <= 1) continue; // Skip numbers less than 2

            boolean isPrime = true;

            // Step 2: Check if the number is prime
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false; // Number is divisible by i, so it's not prime
                    break;
                }
            }

            // If the number is prime, add it to the list
            if (isPrime) {
                primesInRange.add(num);
            }
        }

        return primesInRange;
    }
}