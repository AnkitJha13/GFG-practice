class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        int smallest = Integer.MAX_VALUE;
        int ssmallest = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] < smallest){
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] != smallest && arr[i] < ssmallest){
                ssmallest = arr[i];
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        
        if(ssmallest == Integer.MAX_VALUE){
            res.add(-1);
        }
        else{
            res.add(smallest);
            res.add(ssmallest);
        }
        
        return res;
    }
}
