package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {

    /**
     * 动态规划的解决方法如下：
     * 1. 定义状态：
     * * * 我们可以使用一个二维数组 dp，其中 dp[i][j] 表示第一个字符串的前 i 个字符与第二个字符串的前 j 个字符的最长公共子序列的长度。
     * 
     * 2. 状态转移方程：
     * * * 如果 text1[i-1] 等于 text2[j-1]，那么最长公共子序列的长度应该是 dp[i-1][j-1] + 1，因为它们在最长公共子序列的末尾。
     * * * 如果 text1[i-1] 不等于 text2[j-1]，那么我们可以选择忽略其中一个字符，即 dp[i-1][j] 或 dp[i][j-1] 中的最大值。
     * 综上，状态转移方程为：
     * if (text1[i-1] == text2[j-1]) {
     *      dp[i][j] = dp[i-1][j-1] + 1;
     * } else {
     *      dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
     * }
     * 
     * 3. 处理边界条件：
     * * * 当一个字符串的长度为0时，最长公共子序列的长度肯定是0，因此 dp[i][0] = 0 和 dp[0][j] = 0。
     * 
     * 4. 计算顺序：我们可以从左上角开始，按行从左到右、按列从上到下地填充 dp 数组。
     * * * 最终结果：最终的答案是 dp[m][n]，其中 m 和 n 分别是两个字符串的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // text1 的第 i 个字符与 text2 的第 j 个字符相等
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
