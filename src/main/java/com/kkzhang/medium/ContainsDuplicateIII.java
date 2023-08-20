package com.kkzhang.medium;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 2, 3, 4, 5 };
        int indexDiff = 3;
        int valueDiff = 0;
        containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
    }

    /**
     * 解题思路：
     * 这道题目要求判断数组中是否存在两个不同的索引 i 和 j，使得 abs(nums[i] - nums[j]) <= t，并且 abs(i - j) <=
     * k。
     * 可以使用滑动窗口和有序集合（TreeSet）来解决。
     * 
     * 具体步骤如下：
     * 1. 使用有序集合（TreeSet）来存储滑动窗口中的元素，初始时滑动窗口为空。
     * 2. 遍历数组，对于每个元素，首先判断有序集合中是否存在大于等于当前元素的最小值，如果存在并且差值小于等于 t，则返回 true。
     * 3. 将当前元素加入到有序集合中，并判断有序集合的大小是否超过 k，如果超过，则移除滑动窗口的第一个元素。
     * 4. 遍历完成后，如果没有返回 true，则返回 false。
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0) {
            return false;
        }

        int left = 0, right = 0;
        TreeSet<Integer> window = new TreeSet<>();
        while (right < nums.length) {
            // 找到大于等于 nums[right] - valueDiff 的最小值
            Integer ceiling = window.ceiling(nums[right] - valueDiff); 
            if (ceiling != null && ceiling <= nums[right] + valueDiff) {
                return true;
            }
            window.add(nums[right]);
            right++;

            while (window.size() > indexDiff) {
                window.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
