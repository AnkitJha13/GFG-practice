//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            int target = sc.nextInt();
            if (sc.hasNextLine())
                sc.nextLine(); // consume the newline after reading target

            Solution obj = new Solution();
            System.out.println(obj.numberOfSubarrays(arr, target));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        
        int count = 0, sum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            
            if(map.containsKey(sum - target)){
                count += map.get(sum - target);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}