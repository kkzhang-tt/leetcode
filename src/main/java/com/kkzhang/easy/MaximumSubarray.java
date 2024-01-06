package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    // f[i] 表示以 i 结尾的最大子数组的和
    // f[i] = f[i-1] + nums[i] if (f[i-1] >= 0)
    // f[i] = nums[i] if (f[i-1] < 0)
    public static int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < nums.length; i++) {
            if (f[i - 1] < 0) {
                f[i] = nums[i];
            } else {
                f[i] = f[i - 1] + nums[i];
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    // not correct
    public int maxSubArray3(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            curSum += nums[right];
            maxSum = Math.max(maxSum, curSum);
            while (curSum < 0) {
                curSum -= nums[left];
                left++;
            }

            right++;
        }
        return maxSum;
    }

}
