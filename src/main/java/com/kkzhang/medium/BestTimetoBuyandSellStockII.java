package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimetoBuyandSellStockII {
    /**
     * 解题思路：
     * 本题可以采用贪心算法来解决。
     * 贪心算法的思路是只要当天的股票价格比前一天的股票价格高，就进行买入和卖出操作，以获取最大的利润。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 maxProfit 为 0，表示当前的最大利润。
     * 2. 遍历数组 prices，从第 2 天开始判断，如果当天的股票价格大于前一天的股票价格，就将差值累加到 maxProfit 上。
     * 3. 返回 maxProfit。
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    // 最大子数组和
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
        for (int i = 1; i < n; i++) {
            if (sub[i] >= 0) {
                maxProfit += sub[i];
            }
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }
}
