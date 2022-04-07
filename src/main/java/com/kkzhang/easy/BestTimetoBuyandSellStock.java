package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock {
    // 最大子数组和
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[] sub = new int[n];
        int[] f = new int[n];
        sub[0] = 0;
        for (int i = 1; i < n; i++) {
            sub[i] = prices[i] - prices[i - 1];
        }

        f[0] = sub[0];
        int maxProfit = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] < 0 ? sub[i] : f[i - 1] + sub[i];
            maxProfit = Math.max(maxProfit, f[i]);
        }
        return maxProfit;
    }
}
