class Solution {
    public int reverseExponentiation(int n) {
        // code here
        int originalNum = n;
        int rev = 0;
        while(n != 0){
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n/10;
        }
        
        int result = 1;
        
        for(int i=0;i<rev;i++){
            result *= originalNum;
        }
        
        return result;
    }
}
