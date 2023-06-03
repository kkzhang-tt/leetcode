package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsDuplicateII {
    /**
     * 解题思路：
     * 该问题可以通过哈希表来解决。我们可以遍历数组，使用哈希表来存储每个元素及其对应的索引。在遍历过程中，对于每个元素
     * nums[i]，我们检查哈希表中是否存在与 nums[i] 相同的元素，并且其索引与 i 的差的绝对值不大于 k。如果存在，则说明满足题目要求，返回
     * true。如果遍历完成后仍未找到符合条件的元素，则返回 false。
     * 
     * 具体步骤如下：
     * 1. 初始化一个空的哈希表 map，用于存储元素及其对应的索引。
     * 2. 遍历数组 nums 的每个元素 nums[i]：
     * * 如果 map 中存在与 nums[i] 相同的元素，并且其索引与 i 的差的绝对值不大于 k，则返回 true。
     * * 将 nums[i] 添加到 map 中，以 nums[i] 为 key，i 为 value。
     * 3. 遍历完成后仍未找到符合条件的元素，返回 false。
     * 
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur) && i - map.get(cur) <= k) {
                return true;

            }
            map.put(cur, i);
        }
        return false;
    }
}
