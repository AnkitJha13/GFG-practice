//{ Driver Code Starts
import java.util.*;

class Disjoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
            int k = sc.nextInt();
            GfG g = new GfG();
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (s.equals("UNION")) {
                    int x = sc.nextInt();
                    int z = sc.nextInt();
                    g.unionSet(a, x, z);
                } else {
                    int x = sc.nextInt();
                    int parent = g.find(a, x);
                    System.out.print(parent + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // Path Compression: makes future lookups faster
        if (par[x] != x) {
            par[x] = find(par, par[x]);
        }
        return par[x];
    }

    void unionSet(int par[], int x, int z) {
        int px = find(par, x); // Find parent of x
        int pz = find(par, z); // Find parent of z

        if (px != pz) {
            par[px] = pz; // Make parent of z point to parent of x
        }
    }
}

