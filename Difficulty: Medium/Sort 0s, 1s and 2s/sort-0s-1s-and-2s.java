class Solution {
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        int low=0, mid=0, high=n-1;
        
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }
}