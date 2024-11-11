//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public String FirstNonRepeating(String s) {
        int[] freq = new int[26]; // Array to store frequency of each character
        Queue<Character> q = new LinkedList<>(); // Queue to maintain the order of characters
        StringBuilder result = new StringBuilder(); // StringBuilder to store the result

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; // Increment frequency of the character
            q.add(ch); // Add the character to the queue

            // Remove characters from the queue that have frequency > 1
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // Append the first non-repeating character or '#' if none exists
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }

        return result.toString(); // Convert StringBuilder to String
    }
}