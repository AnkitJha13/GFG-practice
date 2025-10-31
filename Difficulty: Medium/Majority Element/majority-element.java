class Solution {
    int majorityElement(int arr[]) {
        // code here
        int cnt = 0;
        int el = -1;
        
        for(int i=0;i<arr.length;i++){
            if(cnt == 0){
                cnt = 1;
                el = arr[i];
            }
            
            else if(arr[i] == el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        
        int cnt1 = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == el){
                cnt1++;
            }
            if(cnt1 > arr.length/2){
                return el;
            }
        }
        
        return -1;
        
    }
}