package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/search-insert-position/?envType=study-plan-v2&envId=top-interview-150
 */
public class SearchInsertPosition {
    /**
     * 解题思路：
     * 这道题可以使用二分查找来解决。由于数组是有序的，我们可以利用二分查找的思想来快速定位目标值的位置。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 left 为 0，right 为数组长度减 1。
     * 2. 进入循环，当 left 小于等于 right 时，执行以下操作：
     * * 计算中间位置 mid，为 (left + right) / 2。
     * * 如果目标值等于中间位置的值 nums[mid]，直接返回 mid。
     * * 如果目标值小于中间位置的值 nums[mid]，说明目标值应该在左半部分，将 right 更新为 mid - 1。
     * * 如果目标值大于中间位置的值 nums[mid]，说明目标值应该在右半部分，将 left 更新为 mid + 1。
     * 3. 如果循环结束后仍然没有找到目标值，说明目标值不存在于数组中，返回 left，即为目标值按顺序插入的位置。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
