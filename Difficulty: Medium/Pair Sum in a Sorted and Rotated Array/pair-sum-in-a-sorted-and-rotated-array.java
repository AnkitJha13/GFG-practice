
class Solution {
    static boolean pairSum(int arr[], int target){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int complement = target - arr[i];
            
            if(set.contains(complement)){
                return true;
            }
            
            set.add(arr[i]);
        }
        
        return false;
    }
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        
        if(pairSum(arr, target)){
            return true;
        }
        else{
            return false;
        }
        
    }
}
