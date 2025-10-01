// User function Template for Java
class Solution {
    public static int LCM(int a, int b) {

        // write your code here
        int max = Math.max(a, b);
        int lcm = max;
        
        while(lcm % a != 0 || lcm % b != 0){
            lcm += max;
        }
        
        return lcm;
        

        // return LCM of a and b
    }
}