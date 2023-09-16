package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    // f[i] 表示以 nums[i] 结尾的最长递增子序列的长度
    // f[i] = max{f[j]} + 1，其中 0 <= j < i，并且 nums[j] < nums[i]
    // f[i] = 1，其中 nums[j] >= nums[i]
    // 时间复杂度为 O(n^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int max = 1;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    /**
     * 解题思路：
     * 1. 创建一个与原数组等长的数组 dp，dp[i] 表示以第 i 个元素结尾的最长递增子序列的长度。
     * 2. 初始化 dp 数组为 1，因为单个元素本身就是一个递增子序列。
     * 3. 遍历数组，对于每个位置 i，再遍历其前面的所有位置 j（0 <= j < i），如果 nums[i] > nums[j]，说明 i 可以接在 j
     * 4. 后面形成一个更长的递增子序列，更新 dp[i] = max(dp[i], dp[j] + 1)。
     * 5. 最终，dp 数组中的最大值就是所求的最长递增子序列的长度。
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
