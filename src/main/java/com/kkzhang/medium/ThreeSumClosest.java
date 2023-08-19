package com.kkzhang.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 解题思路：
     * 这道题是在给定数组中找出三个数的和与目标值最接近的问题。
     * 可以使用双指针法来解决。
     * 首先对数组进行排序，然后固定一个数，使用双指针在剩下的数组中找到另外两个数，使得三个数的和最接近目标值。
     * 
     * 具体步骤如下：
     * 1. 对数组进行排序。
     * 2. 初始化一个变量 res 来保存最接近的和，初始化为一个足够大的数。
     * 3. 遍历数组，将当前数固定为第一个数，然后使用双指针法找到剩下的两个数，使得三个数的和最接近目标值。
     * 4. 在双指针法中，设置左指针 left 为当前数的下一个位置，右指针 right 为数组末尾。
     * * * 在每一步中，计算当前三个数的和，如果与目标值更接近，则更新
     * * * res 的值。然后根据当前和与目标值的大小关系，移动左指针或右指针。
     * 5. 返回 res 的值。
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        int sub = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                int curSub;
                if (curSum > target) {
                    right--;
                    curSub = curSum - target;
                } else {
                    left++;
                    curSub = target - curSum;
                }

                if (curSub < sub) {
                    sum = curSum;
                    sub = curSub;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 0 };
        int target = -100;
        threeSumClosest(nums, target);
    }
}
