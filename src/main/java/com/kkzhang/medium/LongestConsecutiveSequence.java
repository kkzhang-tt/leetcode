package com.kkzhang.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutiveSequence {
    /**
     * 解题思路：
     * 该问题可以通过使用哈希表来解决。我们可以先将数组中的所有元素存入哈希表中，并初始化最长连续序列的长度为 0。然后遍历数组中的每个元素
     * num，对于每个元素，判断 num - 1 是否存在于哈希表中。如果不存在，则说明 num
     * 是一个连续序列的起点，我们可以从该点开始向后进行连续序列的计数。
     * 
     * 具体步骤如下：
     * 1. 初始化一个空的哈希表 numSet，用于存储数组中的所有元素。
     * 2. 遍历数组 nums 的每个元素 num：
     * * 如果 num - 1 不存在于 numSet 中，说明 num 是一个连续序列的起点。
     * * 在 numSet 中以 num 为起点，不断向后遍历并计数，直到遇到不连续的元素。将计数结果与当前最长连续序列的长度进行比较，更新最长连续序列的长度。
     * 3. 返回最长连续序列的长度。
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curLength = 1;
                while (set.contains(++num)) {
                    curLength++;
                }
                longest = Math.max(curLength, longest);
            }
        }
        return longest;
    }
}
