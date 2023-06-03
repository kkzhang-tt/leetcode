package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&id=top-interview-150
 */
public class MinimumSizeSubarraySum {
    /**
     * 解题思路：
     * 题目要求找到数组中满足其和大于等于目标值的最小连续子数组的长度。可以使用滑动窗口的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 初始化两个指针 start 和 end，表示子数组的起始位置和结束位置，初始值都为 0。
     * 2. 初始化变量 minLen，表示满足条件的最小子数组的长度，初始值为正无穷大。
     * 3. 初始化变量 sum，表示当前子数组的和，初始值为 0。
     * 4. 遍历数组 nums，对于每个元素 num：
     * * 将 num 加到 sum 中。
     * * 如果 sum 大于等于 target，则进入循环：
     * * * 更新 minLen，将 end - start + 1 和当前的 minLen 中的较小值赋给 minLen。
     * * * 将 nums[start] 从 sum 中减去。
     * * * 将 start 向右移动一位，继续检查是否满足条件。
     * 5. 最后判断 minLen 是否仍然是正无穷大，如果是，则表示没有满足条件的子数组，返回 0；否则返回 minLen。
     * 
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        // 先移动 end 指针
        while (end < nums.length) {
            sum = sum + nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                // 再移动 start 指针
                sum = sum - nums[start];
                start++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
