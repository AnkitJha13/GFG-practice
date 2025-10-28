
class Solution {
    private static void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void zigZag(int[] arr) {
        // code here
        for(int i=0;i<arr.length-1;i++){
            if(i%2==0){
                if(arr[i] > arr[i+1]){
                   swapElements(arr, i, i+1);
                }
            }
            
            else{
                if(arr[i] < arr[i+1]){
                   swapElements(arr, i, i+1);    
                }
            }
        }
    }
}
