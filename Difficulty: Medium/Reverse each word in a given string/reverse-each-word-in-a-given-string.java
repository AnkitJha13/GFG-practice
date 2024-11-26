//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Read the number of test cases
        sc.nextLine();        // Consume the newline character after reading the integer

        while (t-- > 0) {
            String s = sc.nextLine(); // Read the input string

            // Remove surrounding quotes from the string
            String str = s.substring(1, s.length() - 1);

            Solution obj = new Solution(); // Create an object of the Solution class
            String ans = obj.reverseWords(str); // Reverse the words in the string

            // Print the result with surrounding quotes
            System.out.println("\"" + ans + "\"");
            System.out.println("~"); // Print separator
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        boolean wordStarted = false;  // To handle spaces between words
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == ' ') {
                if (wordStarted) {  // Only add space if a word has started
                    // Pop all characters from the stack to form the reversed word
                    while (!st.isEmpty()) {
                        ans += st.pop();
                    }
                    ans += ' ';  // Add a space after the word
                    wordStarted = false;  // Reset the flag after space
                }
            } else {
                st.push(curr);  // Push character onto the stack
                wordStarted = true;  // Mark that a word has started
            }
        }

        // Handle the last word (since there won't be a space after the last word)
        if (wordStarted) {
            while (!st.isEmpty()) {
                ans += st.pop();
            }
        }

        return ans.trim();  // Return the final string
    }
}


