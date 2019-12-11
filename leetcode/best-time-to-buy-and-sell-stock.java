/**
 * 문제: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 풀이: https://bcp0109.tistory.com/143
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
}
