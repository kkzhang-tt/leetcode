package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * 解题思路：
     * 这道题可以使用二分搜索来解决。
     * 由于数组在某个点上进行了旋转，所以我们可以利用二分搜索来找到旋转点，即数组中最小的元素。
     * 
     * 具体步骤如下：
     * 1. 初始化左边界 left 为0，右边界 right 为数组长度减1。
     * 2. 进入循环，当左边界小于右边界时，执行以下操作：
     * * 2.1 计算中间位置 mid。
     * * 2.2 如果 nums[mid] 小于 nums[right]，说明最小值在左半部分，将 right 更新为 mid。
     * * 2.3 否则，说明最小值在右半部分，将 left 更新为 mid + 1。
     * 3. 循环结束时，left 的值就是最小值。
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int right = nums.length - 1;
        int left = 0;
        // 虽然 right 初始化成 num.lenght - 1, 但是使用的是左闭右开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
