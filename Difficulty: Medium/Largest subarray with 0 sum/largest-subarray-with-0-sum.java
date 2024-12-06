//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    int maxLen(int arr[]) {
        // code here
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;       // To store the cumulative sum.
        int maxLen = 0;    // To store the maximum length of subarray with sum 0.

        for (int i = 0; i < arr.length; i++) {
            // Add current element to the cumulative sum.
            sum += arr[i];

            // If sum is 0, update maxLen to the current index + 1.
            if (sum == 0) {
                maxLen = i + 1;
            }

            // If sum has been seen before, calculate the length of the subarray.
            if (preSumMap.containsKey(sum)) {
                int len = i - preSumMap.get(sum);
                maxLen = Math.max(maxLen, len);
            } else {
                // If sum is not already in the map, add it with the current index.
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}