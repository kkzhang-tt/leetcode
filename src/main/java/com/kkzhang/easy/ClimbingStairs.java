package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * 解题思路：
     * 这道题可以使用动态规划来解决。
     * 假设我们要爬到第 n 阶楼顶，那么有两种情况：
     * 1. 如果我们从第 n-1 阶爬一阶上来，那么到达第 n 阶的方法数为爬到第 n-1 阶的方法数；
     * 2. 如果我们从第 n-2 阶爬两阶上来，那么到达第 n 阶的方法数为爬到第 n-2 阶的方法数。
     * 所以，到达第 n 阶的方法数为爬到第 n-1 阶和第 n-2 阶方法数之和。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 dp，其中 dp[0] 为爬到第 0 阶的方法数，dp[1] 为爬到第 1 阶的方法数。
     * 2. 进入循环，从第 2 阶开始遍历到第 n 阶，执行以下操作：
     * 3. 计算爬到当前阶数的方法数，即 dp[i] = dp[i-1] + dp[i-2]。
     * 4. 循环结束后，dp[n] 即为爬到第 n 阶的方法数，返回 dp[n]。
     * 
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // f[i] 表示爬到第 i 层的方式数目
    // f[i] = f[i-1] + f[i-2]
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
