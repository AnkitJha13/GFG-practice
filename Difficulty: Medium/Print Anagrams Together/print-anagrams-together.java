//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String, List<String>> res = new HashMap<>();
        
        for (String s : arr) {
            int[] count = new int[26];
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            String keys = Arrays.toString(count);
            
            res.putIfAbsent(keys, new ArrayList<>());
            res.get(keys).add(s);
        }
        
    
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        // Add each list of anagrams to the result
        for (List<String> group : res.values()) {
            result.add(new ArrayList<>(group)); // Create a new ArrayList for each group
        }

        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends