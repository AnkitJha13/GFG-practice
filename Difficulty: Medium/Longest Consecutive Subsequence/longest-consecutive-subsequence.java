//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length;
        
        if(n == 0) return 0;
        
        int longest = 1;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(arr[i]);
        }
        
        for(int it : st){
            if(!st.contains(it-1)){
                int x = it;
                int cnt = 1;
                
                while(st.contains(x+1)){
                    x = x + 1;
                    cnt++;
                }
                
                longest = Math.max(longest, cnt);
            }
        }
        
        return longest;
    }
}