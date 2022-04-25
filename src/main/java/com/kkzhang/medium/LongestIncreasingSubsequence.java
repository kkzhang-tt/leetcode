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
}
