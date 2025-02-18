//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    static class Coordinate implements Comparable<Coordinate>{
        int x, y;
        int distanceSq;
        
        Coordinate(int x, int y){
           this.x = x;
           this.y = y;
           this.distanceSq = x * x + y * y;
        }
        
        @Override
        public int compareTo(Coordinate other){
            return this.distanceSq - other.distanceSq;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        
        PriorityQueue<Coordinate> pq = new PriorityQueue<>();
        for(int[] point : points){
            pq.add(new Coordinate(point[0], point[1]));
        }
        
        int[][] closestPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            Coordinate closest = pq.remove();
            closestPoints[i][0] = closest.x;
            closestPoints[i][1] = closest.y;
        }
        
        return closestPoints;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends