//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(new Solution().KthLargest(a, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int k) {
        // Your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : arr){
            minHeap.add(num);
            
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        return minHeap.peek();
    }
}