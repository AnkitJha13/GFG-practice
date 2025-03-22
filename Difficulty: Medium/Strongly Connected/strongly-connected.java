//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find number of strongly connected components in the graph.
    private void dfs1(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, Stack<Integer> stack){
        vis[node] = true;
        for(Integer neighbor : adj.get(node)){
            if(!vis[neighbor]){
                dfs1(adj, neighbor, vis, stack);
            }
        }
        stack.push(node);
    }
    
    private void dfs2(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs2(adj, neighbor, visited);
            }
        }
    }
    
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        
        // first perform simple DFS and store nodes in stack
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs1(adj, i, vis, stack);
            }
        }
        
        
        // Step 2: Reverse (Transpose) the graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                revAdj.get(neighbor).add(i); // Reverse edge direction
            }
        }
        
         // Step 3: Perform DFS on reversed graph
        Arrays.fill(vis, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!vis[node]) {
                dfs2(revAdj, node, vis);
                sccCount++;  // Found one SCC
            }
        }

        return sccCount;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends