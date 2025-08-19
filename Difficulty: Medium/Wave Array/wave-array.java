class Solution {
    
    void swap(int arr[], int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    public void sortInWave(int arr[]) {
        // code here
        int n = arr.length;
        
        for(int i=0;i<n;i+=2){
            if(i+1 < n){
                swap(arr, i, i+1);
            }
        }
        
    }
}
