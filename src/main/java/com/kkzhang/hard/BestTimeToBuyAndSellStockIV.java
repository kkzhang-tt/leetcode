package com.kkzhang.hard;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * 解题思路：
     * 这是一个动态规划问题。
     * 我们可以使用一个二维数组 dp 来保存在每一天进行的交易次数和当前持有状态下的最大利润。
     * 
     * dp[i][k][0] 表示第i天结束时，最多进行k次交易，且不持有股票的最大利润。dp[i][k][1] 表示第i天结束时，最多进行k次交易，且持有股票的最大利润。
     * 使用状态转移方程来更新 dp 数组：
     * * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])（表示第i天不持有股票，可以是前一天也不持有，或者前一天持有但在第i天卖出）。
     * * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])（表示第i天持有股票，可以是前一天也持有，或者前一天不持有但在第i天买入）。
     * 最终的答案就是 dp[n-1][k][0]，其中 n 是股票价格数组的长度
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            // 可以进行无限次交易，相当于不限制交易次数
            return maxProfit(prices);
        }

        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                // 买股票算一次交易，卖股票不算交易
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
