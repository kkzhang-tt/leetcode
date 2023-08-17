package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    /**
     * 解题思路：
     * 这道题可以使用二分搜索来解决。
     * 由于题目已经明确数组中的任意相邻元素都不相等，所以数组中一定存在峰值元素。
     * 
     * 具体步骤如下：
     * 1. 初始化左边界 left 为0，右边界 right 为数组长度减1。
     * 2. 进入循环，当左边界小于右边界时，执行以下操作：
     * * 2.1 计算中间位置 mid。
     * * 2.2 如果 nums[mid] < nums[mid+1]，说明峰值在 mid 右边，将 left 更新为 mid + 1。
     * * 2.3 否则，说明峰值在 mid 左边，将 right 更新为 mid。
     * 3. 循环结束时，left 的值就是峰值的位置。
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        // 因为肯定会存在目标值，所以使用 left<right
        // 这样当循环终止时，剩余的元素 left 就是目标值
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
