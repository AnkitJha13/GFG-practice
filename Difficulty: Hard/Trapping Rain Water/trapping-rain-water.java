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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int twater = 0, left = 0, right = arr.length-1;
        int leftMax = arr[left], rightMax = arr[right];
        
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                twater += leftMax - arr[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                twater += rightMax - arr[right];
            }
        }
        
        return twater;
    }
}
