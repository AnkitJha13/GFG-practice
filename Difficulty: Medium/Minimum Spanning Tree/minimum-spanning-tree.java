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
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1])); //sorting according to weights
        int[] visited=new int[V];
        int sum=0;
        pq.add(new int[]{0,0}); //node,weight;
        
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            int u=curr[0];
            int wt=curr[1];
            if(visited[u]==1) continue;
            
            visited[u]=1;
            sum+=wt;
            for(int[] neighbor:adj.get(u)){
                int v=neighbor[0];
                int w=neighbor[1];
                if(visited[v]==0) pq.add(new int[]{v,w});
            }
            
        }
        return sum;
        
    }
}

