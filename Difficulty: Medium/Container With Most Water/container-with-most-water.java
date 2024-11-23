//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxArea(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxArea(int arr[]) {
        // Code Here
        int left = 0;
        int right = arr.length-1;
        
        int maxWater = 0;
        
        while(left < right){
            int minHeight = Math.min(arr[left], arr[right]);
            
            int width = right-left;
            maxWater = Math.max(maxWater, width * minHeight);
            
            if(arr[left] < arr[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return maxWater;
    }
}