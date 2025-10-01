class Solution {
    public static void print_divisors(int n) {
        // code here
        List<Integer> divisors = new ArrayList<>();
        
        // Find divisors up to sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) { // To avoid adding square root twice
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
