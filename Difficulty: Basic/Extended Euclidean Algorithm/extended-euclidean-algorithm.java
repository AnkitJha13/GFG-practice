// User function Template for Java
class Solution {
    static int[] gcd(int a, int b) {
        // code here
        // Base case
        if (b == 0) {
            return new int[]{a, 1, 0};  // gcd, x, y
        }
        
        // Recursive call
        int[] vals = gcd(b, a % b);  
        int gcd = vals[0];
        int x1 = vals[1];
        int y1 = vals[2];
        
        // Update x and y using back-substitution
        int x = y1;
        int y = x1 - (a / b) * y1;
        
        return new int[]{gcd, x, y};
    }
}