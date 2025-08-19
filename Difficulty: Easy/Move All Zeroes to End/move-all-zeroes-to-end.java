class Solution {
    
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    void pushZerosToEnd(int[] arr) {
        // code here
        int j = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        
        if(j==-1){
            return ;
        }
        
        for(int i=j+1;i<arr.length;i++){
            if(arr[i] != 0){
                swap(arr, i, j);
                j++;
            }
        }
    }
}