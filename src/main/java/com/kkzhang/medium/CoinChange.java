package com.kkzhang.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    // 每种硬币数不限
    // 动态规划，而不是贪心
    // f[i] 表示面额为 i 时的最少硬币数
    // f[i] = min(f[i-c]+1), i>=c, c 为各个硬币面值
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[] f = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            f[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[amount] == amount + 1 ? -1 : f[amount];
    }
}
