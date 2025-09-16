class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        
        int n = arr.length;
        
        if(n==0 || n==1) return true;
        
        for(int i=1;i<n;i++){
            if(arr[i] < arr[i-1]) return false;
        }
        
        return true;
        
    }
}