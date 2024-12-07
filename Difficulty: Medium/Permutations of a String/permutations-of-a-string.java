//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.findPermutation(S);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {

    // Helper function to generate permutations using backtracking
    private void generatePermutations(int index, char[] s, List<String> result) {
        // Base case: when the index reaches the length of the string, add the permutation
        if (index == s.length) {
            result.add(new String(s)); // Add the current permutation as a string
            return;
        }

        Set<Character> used = new HashSet<>(); // Set to track used characters at the current level
        // Loop through each character and swap to generate permutations
        for (int i = index; i < s.length; i++) {
            // If the character has already been used at this level, skip it to avoid duplicates
            if (used.contains(s[i])) {
                continue;
            }
            // Mark the character as used
            used.add(s[i]);

            // Swap characters at index and i to create a new permutation
            swap(i, index, s);

            // Recursively generate the next part of the permutation
            generatePermutations(index + 1, s, result);

            // Swap back to undo the change and proceed with the next character
            swap(i, index, s);
        }
    }

    // Helper function to swap two characters in the array
    private void swap(int i, int j, char[] s) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public List<String> findPermutation(String s) {
        List<String> result = new ArrayList<>();

        // Convert the string to a character array to work with it easily
        char[] arr = s.toCharArray();

        // Generate all permutations
        generatePermutations(0, arr, result);

        // Return the result list containing unique permutations
        result.sort(String::compareTo);
        return result;
    }
}