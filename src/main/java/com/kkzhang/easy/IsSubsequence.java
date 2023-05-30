package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    /**
     * 解题思路：
     * 题目要求判断字符串 s 是否为字符串 t 的子序列。可以使用双指针的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 初始化指针 i 和 j 分别指向字符串 s 和 t 的起始位置。
     * 2. 遍历字符串 t，如果当前字符与指针 i 所指的字符相等，则将指针 i 后移。
     * 3. 最后判断指针 i 是否达到了字符串 s 的末尾。如果是，则表示 s 是 t 的子序列，返回 true；否则返回 false。
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == s.length()) {
            return true;
        }
        return false;
    }

    // 思路不对
    public boolean isSubsequence2(String s, String t) {
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
