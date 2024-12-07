//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                for (int num : subset) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private void generateSubsets(int idx, int arr[], ArrayList<Integer> current, 
                                 ArrayList<ArrayList<Integer>> result) {
        if (idx == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Exclude the current element
        generateSubsets(idx + 1, arr, current, result);
        
        // Include the current element
        current.add(arr[idx]);
        generateSubsets(idx + 1, arr, current, result);
        
        // Backtrack to remove the added element
        current.remove(current.size() - 1);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // Sort the array to ensure lexicographical order
       
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubsets(0, arr, new ArrayList<>(), result);
        
        
        Collections.sort(result, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });
        
        return result;
    }
}