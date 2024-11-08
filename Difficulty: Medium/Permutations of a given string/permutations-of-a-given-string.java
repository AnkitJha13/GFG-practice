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
    private void findPermu(char[] chars, boolean[] used, StringBuilder ans, List<String> result) {
        // Base case: if the current permutation has all characters, add it to the result
        if (ans.length() == chars.length) {
            result.add(ans.toString());
            return;
        }

        // Recur for each character
        for (int i = 0; i < chars.length; i++) {
            // Skip already used characters
            if (used[i]) continue;

            // Skip duplicates: if the current character is the same as the previous one
            // and the previous one was not used in the current branch of recursion
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // Include the character in the permutation
            used[i] = true;
            ans.append(chars[i]);

            // Recurse for the next character
            findPermu(chars, used, ans, result);

            // Backtrack
            used[i] = false;
            ans.deleteCharAt(ans.length() - 1);
        }
    }

    public List<String> findPermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort to handle duplicates easily
        findPermu(chars, new boolean[chars.length], new StringBuilder(), result);
        return result;
    }
}