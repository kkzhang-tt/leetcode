package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
    // 思路不对
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int m = s.length();
        int n = t.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            f[i][0] = false;
        }
        for (int j = 1; j < n + 1; j++) {
            f[0][j] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    if (f[i - 1][j] || f[i][j - 1]) {
                        f[i][j] = true;
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }
        return f[m][n];
    }
}
