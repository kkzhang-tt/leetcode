package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {
    // 贪心算法
    public boolean checkPossibility(int[] nums) {
        int modifyCount = 0;
        for (int i = 1; i < nums.length; i++) {
            // 需要进行一次更改，但是更改哪个元素还需要进一步判断
            if (nums[i - 1] > nums[i]) {
                modifyCount++;
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    // 如果同时 nums[i-2]<=nums[i]，那么需要更改 nums[i-1]
                    nums[i - 1] = nums[i];
                } else {
                    // 否则只需要更新 nums[i]
                    nums[i] = nums[i - 1];
                }
            }
        }
        return modifyCount <= 1;
    }
}
