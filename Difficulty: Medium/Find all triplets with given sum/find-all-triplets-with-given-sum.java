
class Solution {
    public ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            
            int j = i+1;
            int l = n-1;
            
            while(j<l){
                int sum = arr[i] + arr[j] + arr[l];
                
                if(sum < k){
                    j++;
                }
                else if(sum > k){
                    l--;
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[l]));
                    ans.add(temp);
                    
                    j++;
                    l--;
                    
                    while(j<l && arr[j] == arr[j-1]) j++;
                    while(j<l && arr[l] == arr[l+1]) l--;
                }
            }
        }
        
        return ans;
    }
}
