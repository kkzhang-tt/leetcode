package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    /**
     * 解题思路：
     * 这道题可以使用荷兰国旗问题的思想，通过三个指针来进行原地排序。
     * 
     * 具体步骤如下：
     * 1. 使用三个指针 left、right 和 current 分别表示当前处理的位置、左边界和右边界。
     * 2. 当 nums[current] 为 0 时，将其与 nums[left] 交换，然后将 left 和 current 向右移动。
     * 3. 当 nums[current] 为 2 时，将其与 nums[right] 交换，然后将 right 向左移动。
     * * * 注意，交换后的 nums[current] 可能为 0 或 1，所以 current 不需要移动，需要继续处理交换后的值。
     * 4. 当 nums[current] 为 1 时，只需要将 current 向右移动。
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int current = 0;
        int right = nums.length - 1;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, right, current);
                right--;
            } else {
                current++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
    }
}
