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
     private ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        ArrayList<Integer> singleComponent = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>(); // Using Queue with LinkedList

        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            singleComponent.add(node);
           
            // Sorting neighbors to ensure BFS follows a consistent order
            Collections.sort(adj.get(node));

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return singleComponent;
    }
    
    public ArrayList<ArrayList<Integer>> connectedcomponents(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected graph
        }

        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] vis = new boolean[V];

        // Step 2: Find all connected components using BFS
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = bfs(i, adj, vis);
                Collections.sort(component); // Sorting the component for ordered output
                components.add(component);
            }
        }

        return components;
    }
}


