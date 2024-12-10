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
        // code here
        double ratio[][] = new double[val.size()][2];
        
        for(int i=0;i<val.size();i++){
            ratio[i][0] = i;
            ratio[i][1] = val.get(i)/(double) wt.get(i);
        }
        
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        
        double finalValue = 0;
        
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int) ratio[i][0];
            if(capacity >= wt.get(idx)){
                finalValue += val.get(idx);
                capacity -= wt.get(idx);
            }
            else{
                finalValue += capacity * ratio[i][1];
                break;
            }
        }
        
        return finalValue;
        
        
    }
}