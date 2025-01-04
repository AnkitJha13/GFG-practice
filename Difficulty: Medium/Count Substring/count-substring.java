//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int left = 0, result = 0;
        int[] count = new int[3];
        
        for(int right=0; right<s.length(); right++){
            count[s.charAt(right) - 'a']++;
            
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += s.length() - right;
                
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return result;
    }
}
        
