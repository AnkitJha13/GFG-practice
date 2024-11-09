//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // Create a 2D array to store index and value-to-weight ratio
        double[][] ratio = new double[val.size()][2];

        // Fill the ratio array
        for (int i = 0; i < val.size(); i++) {
            ratio[i][0] = i; // Index of the item
            ratio[i][1] = val.get(i) / (double) wt.get(i); // Value-to-weight ratio
        }

        // Sort the ratio array in ascending order based on the value-to-weight ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double finalValue = 0; // To store the maximum value we can carry

        // Iterate through items from the highest ratio to the lowest
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; // Get the original index of the item
            if (capacity >= wt.get(idx)) {
                // If the full weight of the item can be taken
                finalValue += val.get(idx); // Add its full value
                capacity -= wt.get(idx); // Decrease capacity
            } else {
                // If only a fraction of the item can be taken
                finalValue += ratio[i][1] * capacity; // Add the fractional value
                break; // Knapsack is full
            }
        }

        return finalValue; // Return the maximum value
    }
}