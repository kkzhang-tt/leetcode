package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    // 错误方法：先反转字符串得到 s'，之后对 s 与 s' 求最长公共子序列的方式
    // DP 方式: f[i][j] 表示 s[i...j] 子串是否是回文: true/false; i<=j
    // f[i][j] = f[i+1][j-1] && s[i] == s[j]
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 0) {
            return "";
        }
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[][] f = new boolean[n][n];
        // i 为左边界, j 为右边界；i <= j
        // j 从 1 开始
        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                f[i][i] = true;
                if (i == j) {
                    // 只有一个字符
                    f[i][j] = true;
                } else if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
                    // 两个字符，且相等
                    f[i][j] = true;
                } else if (i + 1 == j && s.charAt(i) != s.charAt(j)) {
                    // 两个字符，且不相等
                    f[i][j] = false;
                } else {
                    f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (f[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
