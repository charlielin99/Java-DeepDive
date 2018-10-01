class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length < 2){
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = prices[1] - prices[0] > 0 ? prices[1]-prices[0] : 0;
        
        for (int i=1; i<prices.length; i++){
            int currentPrice = prices[i];
            int potentialProfit = currentPrice - minPrice;
            
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, currentPrice);
        }
        
        return maxProfit; 
    }
}