package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {
    // 参考答案
    // 自己按照 n&(n-1) 的思路没有解出来
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            f[i] = f[i / 2] + (i % 2);
        }
        return f;

    }
}
