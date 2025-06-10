// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        char[] str = s.toCharArray();
        
        int left = 0, right = str.length-1;
        
        while(left < right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(str);
    }
}