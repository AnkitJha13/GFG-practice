// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        
        Set<Integer> set1 = new HashSet<>(arr1);
        Set<Integer> set2 = new HashSet<>(arr2);
        Set<Integer> set3 = new HashSet<>(arr3);
        
        set1.retainAll(set2); // for intersection (keeps only common elements)
        
        set1.retainAll(set3);
        
        List<Integer> res = new ArrayList<>(set1);
        Collections.sort(res);
        return res;
        
        
    }
}