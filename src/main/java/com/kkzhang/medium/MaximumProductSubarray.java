package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    // 参考讨论
    public int maxProduct_1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int maxTemp = Math.max(max * nums[i], min * nums[i]);
            int minTemp = Math.min(max * nums[i], min * nums[i]);
            max = Math.max(maxTemp, nums[i]);
            min = Math.min(minTemp, nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    // 150 / 188 test cases passed.
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = nums[0];
        int max = f[1];
        for (int i = 2; i < n + 1; i++) {
            if (nums[i - 1] * f[i - 1] < 0) {
                if (f[i - 2] < 0) {
                    f[i] = f[i - 2] * nums[i - 2] * nums[i - 1];
                } else {
                    f[i] = nums[i - 1];
                }
            } else if (nums[i - 1] * f[i - 1] == 0) {
                f[i] = nums[i - 1];
            } else {
                if (f[i - 2] > 0) {
                    f[i] = f[i - 2] * nums[i - 2] * nums[i - 1];
                } else {
                    f[i] = f[i - 1] * nums[i - 1];
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
