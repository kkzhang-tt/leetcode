package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock {
    /**
     * 解题思路：
     * 这道题可以使用贪心算法来解决。我们需要找到最低的买入价格和最高的卖出价格，计算它们的差值即为最大利润。
     * 
     * 具体步骤如下：
     * 1. 定义一个变量 minPrice 来保存当前的最低买入价格，初始值为整数最大值。
     * 2. 定义一个变量 maxProfit 来保存当前的最大利润，初始值为 0。
     * 3. 遍历数组 prices，对于每个价格 price，更新 minPrice 为 min(minPrice, price)，表示当前的最低买入价格。
     * 4. 计算当前价格与 minPrice 的差值，如果大于 maxProfit，则更新 maxProfit。
     * 5. 返回 maxProfit。
     * 
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
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

    public int maxProfit3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Integer.min(minPrice, price);
            maxProfit = Integer.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
