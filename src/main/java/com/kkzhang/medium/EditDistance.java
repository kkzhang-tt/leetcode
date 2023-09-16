package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/edit-distance/description/
 */
public class EditDistance {

    /**
     * 解题思路：
     * 这是一个经典的动态规划问题。
     * 我们可以使用动态规划来解决，定义一个二维数组 dp，其中 dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j
     * 个字符所需的最少操作次数。
     * 
     * 我们可以通过以下递推关系来计算 dp[i][j]：
     * 1. 如果 word1[i-1] 等于 word2[j-1]，那么 dp[i][j] = dp[i-1][j-1]，因为不需要进行操作。
     * 2. 否则，我们有三种操作方式：
     * * 2.1 插入操作：dp[i][j] = dp[i][j-1] + 1，表示在 word1 的前 i 个字符后插入一个字符。
     * * 2.2 删除操作：dp[i][j] = dp[i-1][j] + 1，表示删除 word1 的第 i 个字符。
     * * 2.3 替换操作：dp[i][j] = dp[i-1][j-1] + 1，表示将 word1 的第 i 个字符替换为 word2 的第 j 个字符。
     * 3. 最终，dp[word1.length()][word2.length()] 就是将 word1 转换为 word2 所需的最少操作次数
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 创建二维数组dp，dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最少操作次数
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            // word2为空字符串，需要删除word1的i个字符
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            // word1为空字符串，需要插入word2的j个字符
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int update = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(update, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}
