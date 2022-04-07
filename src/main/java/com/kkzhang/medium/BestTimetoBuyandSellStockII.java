package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[] sub = new int[n];
        sub[0] = 0;
        for (int i = 1; i < n; i++) {
            sub[i] = prices[i] - prices[i - 1];
        }

        // 可以多次进行买卖，只要前后两天的价格差 > 0，则进行买卖
        int maxProfit = sub[0];
        for(int i = 1; i < n; i++){
            if(sub[i] >= 0){
                maxProfit += sub[i];
            }
        }
        return maxProfit;
    }
}
