package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&id=top-interview-150
 */
public class MajorityElement {
    /**
     * 解题思路：
     * 题目要求找到出现次数超过数组长度一半的元素，可以使用摩尔投票法解决。
     * 
     * 具体步骤如下：
     * 1. 初始化候选元素 candidate 为数组的第一个元素，计数器 count 为 1。
     * 2. 遍历数组，若当前元素与候选元素相同，则计数器 count 加 1；若当前元素与候选元素不同，则计数器 count 减 1。
     * 3. 当计数器 count 减到 0 时，将当前元素设为候选元素，并将计数器 count 置为 1。
     * 4. 遍历完整个数组后，候选元素 candidate 即为多数元素。
     * 
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int index = 0; index < nums.length; index++) {
            if (candidate == nums[index]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[index];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
