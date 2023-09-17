package com.kkzhang.hard;

/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 */
public class DistinctSubsequences {

    /**
     * 解题思路：
     * 这是一个动态规划问题。
     * 
     * 1. 我们可以使用一个二维数组 dp，其中 dp[i][j] 表示字符串 s 的前 i 个字符和字符串 t 的前 j 个字符之间的不同子序列数量。
     * 2. 初始情况是当 j = 0 时，对于任何 i，dp[i][0] 都应该为1，因为对于任何非空字符串 s，空字符串 t 都是它的子序列。
     * 3. 使用状态转移方程来更新 dp 数组：
     * * * 3.1 如果 s[i-1] 等于 t[j-1]，那么我们有两个选择：
     * * * 3.2 我们可以将 s[i-1] 匹配到 t[j-1]，然后计算 dp[i-1][j-1]。
     * * * 3.3 我们也可以不使用 s[i-1]，然后计算 dp[i-1][j]（这表示我们不使用 s[i-1]，继续在 s 的前 i-1 个字符中找 t 的子序列）。
     * * * * * 所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]。
     * * * 3.4 如果 s[i-1] 不等于 t[j-1]，那么我们只能选择不使用 s[i-1]，即 dp[i][j] = dp[i-1][j]。
     * 4. 计算顺序是从字符串的前部开始，从左到右，从上到下地填充 dp 数组。
     * 5. 最终的答案是 dp[m][n]，其中 m 和 n 分别是字符串 s 和 t 的长度。
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
