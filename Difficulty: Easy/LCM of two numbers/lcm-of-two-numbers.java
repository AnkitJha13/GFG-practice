class Solution {
    public int lcm(int a, int b) {
        // code here
        int max = Math.max(a, b);
        int lcm = max;
        
        while(lcm % a != 0 || lcm % b != 0){
            lcm += max;
        }
        
        return lcm;
    }
}