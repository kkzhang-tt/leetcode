package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
public class LongestPalindromicSubsequence {

    /**
     * 解题思路：
     * 1. 反转字符串s, 生成新的字符串 s2
     * 2. 求字符串 s, s2 的最长公共子序列
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        String s2 = new StringBuffer(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
}
