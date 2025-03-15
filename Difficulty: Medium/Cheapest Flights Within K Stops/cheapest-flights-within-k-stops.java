//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        // Initialize cost array with maximum value
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        // Queue to store [node, cost, stops]
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            
            if (stops > k) continue; // If stops exceed k, skip this path
            
            for (int[] neighbor : adj.get(city)) {
                int nextCity = neighbor[0];
                int price = neighbor[1];
                
                // If a cheaper path is found or within the stop limit
                if (cost + price < minCost[nextCity]) {
                    minCost[nextCity] = cost + price;
                    queue.add(new int[]{nextCity, minCost[nextCity], stops + 1});
                }
            }
        }
        
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}