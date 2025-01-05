//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character

        while (t-- > 0) {
            String[] arrInput = sc.nextLine().split(" ");
            int[] arr = new int[arrInput.length];
            for (int i = 0; i < arrInput.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
            }

            int k = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayCount(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int atMost(int arr[], int k){
        int left = 0, count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < arr.length; right++){
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            while(map.size() > k){
                map.put(arr[left], map.get(arr[left]) - 1);
                
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            
            count += (right-left+1);
        }
        return count;
    }
    static int subarrayCount(int arr[], int k) {
        // code here
        return atMost(arr, k) - atMost(arr, k-1);
    }
}
