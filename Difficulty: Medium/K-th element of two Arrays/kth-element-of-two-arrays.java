//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int i = a.length-1;
        int j = b.length-1;
        int l = a.length + b.length - 1;
        int c[] = new int[l+1];
        
        while(i>=0 && j>=0){
            if(a[i] > b[j]){
                c[l] = a[i];
                l--; i--;
            }
            else{
                c[l] = b[j];
                l--; j--;
            }
        }
        
        while(i>=0){
            c[l] = a[i];
            l--; i--;
        }
        
        while(j>=0){
            c[l] = b[j];
            l--; j--;
        }
        
       
        int count = 1;
        for(int m=0;m<c.length;m++){
            if(count == k){
                return c[m];
            }
            count++;
        }
        return -1;
        
    }
}