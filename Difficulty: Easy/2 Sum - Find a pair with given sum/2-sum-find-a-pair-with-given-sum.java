// User function Template for Java
class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int requiredNum = target - arr[i];
            
            if(map.containsKey(requiredNum)){
                return Arrays.asList(requiredNum, arr[i]);
            }
            
            map.put(arr[i], i);
        }
        
        return new ArrayList<>();
    }
}