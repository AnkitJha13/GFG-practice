// User function Template for Java

class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        Vector<Integer> result = new Vector<>();
        int n = arr.length;
        int carry = 1;  // because we are adding 1
        
        for (int i = n - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }
        
        // If carry is still left, add it
        if (carry > 0) {
            result.add(carry);
        }
        
        // The result is currently reversed, so reverse it back
        Collections.reverse(result);
        
        return result;
        
    }
}