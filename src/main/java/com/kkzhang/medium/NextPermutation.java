package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    /**
     * 解题思路：
     * 这道题的目标是找到一个排列的下一个更大的排列，首先要理解字典序的概念。
     * 字典序就是比较字符串或数字大小的一种方式，
     * 例如在排列 [1, 2, 3] 和 [1, 3, 2] 中，[1, 3, 2] 是 [1, 2, 3] 的下一个字典序排列。
     * 
     * 具体步骤如下：
     * 1. 从右向左遍历数组，找到第一个不满足递增关系的数字，记为 i。
     * * * 即找到最后一个满足 nums[i] < nums[i+1] 的位置。
     * 2. 如果不存在这样的 i，说明整个数组是降序排列的，直接将数组反转，得到升序排列即可。
     * 3. 如果存在 i，再从右向左遍历数组，找到第一个比 nums[i] 大的数字，记为 j。
     * 4. 交换 nums[i] 和 nums[j]。
     * 5. 将位置 i+1 到数组末尾的部分反转，得到下一个更大的排列。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int i = n - 2;
        // 找到第一个不满足递增关系的数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // 找到第一个比 nums[i] 大的数字
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 反转位置 i+1 到数组末尾的部分
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
