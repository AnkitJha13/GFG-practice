//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String S = sc.nextLine();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.countChars(S);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<Integer> countChars (String s)
    {
        // code here
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                sum++;
            }
            else{
                res.add(sum);
                sum = 0;
            }
        }
        res.add(sum);  // for last as there wont be any space left for it so handled separately
        return res;
    }
}
