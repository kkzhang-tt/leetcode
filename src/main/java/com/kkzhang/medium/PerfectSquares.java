package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
    // f[i] 表示 i 的最少平方个数
    // f[i] = min{f[j] + f[i-j]}, 0<= j <= i
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            f[i] = i;
            if (isSquare(i)) {
                f[i] = 1;
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                int sub = i - j;
                f[i] = Math.min(f[i], f[j] + f[sub]);
            }
        }
        return f[n];

    }

    private boolean isSquare(int n) {
        int a = (int) Math.sqrt((double) n);
        return a * a == n;
    }
}
