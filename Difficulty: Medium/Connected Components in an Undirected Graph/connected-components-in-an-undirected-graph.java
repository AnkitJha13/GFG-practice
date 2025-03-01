//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(s[j]);
            }
        }

        return mat;
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (ArrayList<Integer> a : m) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int e = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.connectedcomponents(v, edges);
            Collections.sort(res, (a, b) -> Integer.compare(a.get(0), b.get(0)));
            IntMatrix.print(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Helper function for DFS traversal
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> component) {
        vis[node] = true;
        component.add(node);
        
        // Sort neighbors before traversing to ensure lexicographical order
        Collections.sort(adj.get(node));

        for (Integer neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfsHelper(neighbor, adj, vis, component);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Step 2: Find connected components using DFS
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) { // If node is not visited, it's a new component
                ArrayList<Integer> component = new ArrayList<>();
                dfsHelper(i, adj, vis, component);
                Collections.sort(component); // Sort component before adding
                components.add(component);
            }
        }

        return components;
    }
}