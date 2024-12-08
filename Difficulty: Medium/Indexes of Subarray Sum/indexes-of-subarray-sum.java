//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;

        // Handle subarrays starting from index 0
        preSumMap.put(0, 0);

        for (int i = 0; i < arr.length; i++) {
            // Update the prefix sum
            sum += arr[i];

            // Check if the remaining sum exists in the map
            if (preSumMap.containsKey(sum - target)) {
                result.add(preSumMap.get(sum - target) + 1); // Start index (1-based)
                result.add(i + 1); // End index (1-based)
                return result; // Found the subarray
            }

            // Store the current prefix sum if not already present
            preSumMap.put(sum, i + 1);
        }

        // If no subarray is found
        result.add(-1);
        return result;
    }
}