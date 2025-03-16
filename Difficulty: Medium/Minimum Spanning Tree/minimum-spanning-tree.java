//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Find parent with path compression
    static int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent, parent[node]);
    }

    // Union by rank
    static void unionNodes(int[] parent, int[] rank, int node1, int node2) {
        int root1 = findParent(parent, node1);
        int root2 = findParent(parent, node2);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Step 1: Convert adjacency list to edge list
        for (int i = 0; i < V; i++) {
            for (int[] neighbor : adj.get(i)) {
                int dest = neighbor[0];
                int weight = neighbor[1];
                if (i < dest) {
                    edges.add(new Edge(i, dest, weight));
                }
            }
        }

        // Step 2: Sort edges based on weight
        Collections.sort(edges);

        // Step 3: Initialize Union-Find
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int mstWeight = 0;
        int edgeCount = 0;

        // Step 4: Kruskal's Algorithm
        for (Edge edge : edges) {
            if (findParent(parent, edge.src) != findParent(parent, edge.dest)) {
                mstWeight += edge.weight;
                unionNodes(parent, rank, edge.src, edge.dest);
                edgeCount++;

                if (edgeCount == V - 1) break;
            }
        }

        return mstWeight;
    }
}

