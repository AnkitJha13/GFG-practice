class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        Set<Integer> set = new LinkedHashSet<>();  // LinkedHashSet maintains insertion order
        for(int nums : arr){
            set.add(nums);
        }
        
        return new ArrayList<>(set); // converted set to arraylist
    }
}
