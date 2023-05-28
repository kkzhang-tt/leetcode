package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&id=top-interview-150
 */
public class RotateArray {
    /**
     * 解题思路：
     * 题目要求将数组向右移动k个位置，可以使用反转数组的方法解决。
     * 
     * 具体步骤如下：
     * 1. 首先将整个数组反转。
     * 2. 将前k个元素反转。
     * 3. 将剩余的n-k个元素反转。
     * 4. 最后得到的数组即为所求。
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 处理k大于数组长度的情况

        reverse(nums, 0, n - 1); // 反转整个数组
        reverse(nums, 0, k - 1); // 反转前k个元素
        reverse(nums, k, n - 1); // 反转剩余的n-k个元素
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }
}
