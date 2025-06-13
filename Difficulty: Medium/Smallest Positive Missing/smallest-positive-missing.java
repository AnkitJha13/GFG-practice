
class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        
        Arrays.sort(arr);
        int smallest = 1;
        
        for(int nums : arr){
            if(nums == smallest){
                smallest++;
            }
        }
        
        return smallest;
    }
}
