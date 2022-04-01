package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
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
