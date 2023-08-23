package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 */
public class UniqueBinarySearchTrees {

    /**
     * 解题思路：
     * 这道题是一道动态规划的经典题目，可以使用动态规划的方法来解决。
     * 我们可以定义一个数组 dp，其中 dp[i] 表示以 1 ... i 为节点组成的二叉搜索树的种数。
     * 那么问题的关键就是如何求解 dp[i]。
     * 
     * 对于每个 i，我们可以将每个数字 j（1 <= j <= i）都当作根节点，然后将问题划分为左子树和右子树的子问题。
     * 左子树由节点 1 ... j-1 组成，右子树由节点 j+1 ... i 组成。
     * 而以节点 j 为根节点的二叉搜索树数量等于左子树的数量乘以右子树的数量。所以可以得到以下状态转移方程：
     * f[i] = sum(f[j-1] * f[i-j]), j=[1, i]
     * 备注：j 左侧有 j-1 个递增序列，右侧有 i-j 个递增序列
     * 
     * 具体步骤如下：
     * 1. 初始化数组 dp，长度为 n+1，并将 dp[0] 初始化为 1，表示没有节点的二叉搜索树有 1 种。
     * 2. 从 1 遍历到 n，对于每个 i，计算 dp[i] 的值：
     * * 2.1 内层循环从 1 遍历到 i，对于每个 j，将 dp[i] 增加 dp[j-1] * dp[i-j]，表示以 j 为根节点的二叉搜索树的数量。
     * 3. 返回 dp[n]，即为以 1 ... n 为节点组成的二叉搜索树的种数。
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numTrees(3);
    }
}
