package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    /**
     * 解题思路：
     * 这道题的目标是将数组中的所有 0 移动到末尾，同时保持非零元素的相对顺序。
     * 一个直接的思路是遍历数组，将非零元素放到一个新的数组中，然后将剩余的位置填充 0。
     * 但是题目要求在原地修改数组，所以需要找到一个更优的解法。
     * 
     * 一个比较巧妙的解法是使用双指针。
     * 1. 维护两个指针 left 和 right，初始时都指向数组的头部。
     * 2. 遍历数组，当 nums[right] 不为 0 时，将其与 nums[left] 交换，并将 left 和 right 同时向后移动。
     * * * 这样，当 right 遍历到数组末尾时，left 指向的位置之后都填充 0。
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
                right++;
            } else {
                right++;
            }
        }
    }

    // 最终结果虽然可以将 0 移动到末尾，但是非 0 元素的相对位置会改变
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == 0) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
