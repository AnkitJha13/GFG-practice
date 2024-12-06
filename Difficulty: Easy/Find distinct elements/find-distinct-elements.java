//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    
// } Driver Code Ends
// User function Template for Java

static int distinct(int arr[]) {
    // code here
    Set<Integer> st = new HashSet<>();
    for(int i=0;i<arr.length;i++){
        st.add(arr[i]);
    }
    
    return st.size();
}

//{ Driver Code Starts.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);

            System.out.println(distinct(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends