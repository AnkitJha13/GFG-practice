//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        int count = 0, sum = 0;
        
        Map<Integer, Integer> mpp = new HashMap<>();
        
        mpp.put(0, 1);
        
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            
            if(mpp.containsKey(sum - k)){
                count += mpp.get(sum - k);
            }
            
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}