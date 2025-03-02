//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    private boolean dfsCycle(int current, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[current] = true;

        for (int neighbor : adj.get(current)) {
            if (!vis[neighbor]) {
                if (dfsCycle(neighbor, current, adj, vis)) {
                    return true;   // If any recursive call detects a cycle, return true
                }
            } else if (neighbor != parent) {
                // If visited and not parent, cycle found
                return true;
            } else if (neighbor == parent){
                continue;
            }
            
            // If neighbor == parent, do nothing (Implicit continue)
        }
        return false; // No cycle found in this DFS path
    }
    
    // Function to detect cycle in an undirected graph using DFS
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) { // If not visited, check for cycle
                if (dfsCycle(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;  // No cycle found in any component
    }
}