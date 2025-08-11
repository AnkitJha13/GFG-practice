class Solution {
    int thirdLargest(int arr[]) {
        // Your code here
        int n = arr.length;
        if(arr.length < 3) return -1;
        
        Arrays.sort(arr);
        return arr[n-3];
    }
}