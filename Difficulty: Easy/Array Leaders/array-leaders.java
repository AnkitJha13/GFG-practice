class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int maxi = arr[n-1];
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxi);
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] >= maxi){
                maxi = arr[i];
                ans.add(arr[i]);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
