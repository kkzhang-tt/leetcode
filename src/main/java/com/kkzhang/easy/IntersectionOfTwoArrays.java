package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    /**
     * 解题思路：
     * 这道题可以使用哈希集合来解决，通过存储一个数组中的元素，然后遍历另一个数组，检查元素是否在哈希集合中。
     * 
     * 具体步骤如下：
     * 1. 创建一个哈希集合 set。
     * 2. 遍历第一个数组 nums1，将其中的元素添加到 set 中。
     * 3. 遍历第二个数组 nums2，检查元素是否在 set 中，如果在则将元素添加到结果列表中，并从 set 中删除该元素。
     * 4. 返回结果列表。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map1 = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i : nums1) {
            map1.put(i, true);
        }

        for (int i : nums2) {
            if (map1.containsKey(i)) {
                res.add(i);
                // 避免重复添加
                map1.remove(i);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
