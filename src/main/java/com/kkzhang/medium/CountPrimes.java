package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
    // 对每个数都计算是否是质数，导致超时
    public int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            if (isPrime(i - 1)) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[n];
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
