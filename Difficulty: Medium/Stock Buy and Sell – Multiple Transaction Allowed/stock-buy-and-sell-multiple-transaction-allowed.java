// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int profit = 0;
        
        
        for(int i=1;i<prices.length;i++){
            profit += Math.max(0, prices[i] - prices[i-1]);
        }
        
        return profit;
    }
}