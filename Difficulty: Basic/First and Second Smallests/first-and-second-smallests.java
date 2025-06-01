// User function Template for Java



// User function Template for Java

class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        // code here
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] < smallest){
                ssmallest = smallest;
                smallest = arr[i];
            }
            
            else if(smallest != arr[i] && arr[i] < ssmallest){
                ssmallest = arr[i];
            }
        }
        
         if(ssmallest == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        } 
        else {
            return new int[]{smallest, ssmallest};
        }
    }
}
