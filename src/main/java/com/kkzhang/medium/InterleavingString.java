package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
    // f[i][j] 表示 s3 的 [0...i+j] 子串是否由 s1 的 [0...i] 子串与 s2 的 [0...j] 子串交叉组成
    // f[i][j] = true; 如果 f[i-1][j] == true && s3[i+j] == s1[i] 或者 f[i][j-1] == true
    // && s3[j+j] == s2[j]
    // f[i][j] = false; 如果上述条件均不满足
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if (n + m != k) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];
        // init
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            f[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1][0];
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && f[0][j - 1];
        }
        // iterate
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if ((f[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) ||
                        (f[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1))) {
                    f[i][j] = true;
                } else {
                    f[i][j] = false;
                }
            }
        }
        return f[m][n];
    }
}
