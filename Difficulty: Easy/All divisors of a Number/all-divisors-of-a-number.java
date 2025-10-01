class Solution {
    public static void print_divisors(int n) {
        // code here
        List<Integer> divisors = new ArrayList<>();
        
        // Loop only till sqrt(n), because divisors come in pairs (i, n/i)
        // Example: for 20 -> (1,20), (2,10), (4,5). Beyond sqrt(n), pairs repeat.
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) { // If n is not a perfect square, add the paired divisor (n / i)
                                  // Example: for n = 36, when i = 6 → n/i = 6, avoid duplicate.
                   divisors.add(n / i);
                }
            }
        }
        
        // Sort divisors in ascending order
        Collections.sort(divisors);
        
        // Print all divisors
        for (int d : divisors) {
            System.out.print(d + " ");
        }
    }
}
