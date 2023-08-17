package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i : nums1) {
            int count = map1.getOrDefault(i, 0);
            map1.put(i, count + 1);
        }

        for (int i : nums2) {
            int count = map2.getOrDefault(i, 0);
            map2.put(i, count + 1);
        }

        for (int i : map1.keySet()) {
            if (map2.containsKey(i)) {
                int count1 = map1.get(i);
                int count2 = map2.get(i);
                int count = Integer.min(count1, count2);
                for (int j = 0; j < count; j++) {
                    res.add(i);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    // chagpt generation
    /**
     *  解题思路：
        与前一道题目类似，这道题也可以使用哈希集合来解决，但需要注意的是，这次要计算交集元素的重复次数。

        具体步骤如下：

        创建两个哈希映射 map1 和 map2。
        遍历第一个数组 nums1，将其中的元素作为键，出现次数作为值存储在 map1 中。
        遍历第二个数组 nums2，检查元素是否在 map1 中，如果在，就将元素添加到结果列表中，并将其出现次数减1。
        返回结果列表。
        class Solution {
            public int[] intersect(int[] nums1, int[] nums2) {
                Map<Integer, Integer> map1 = new HashMap<>();
                Map<Integer, Integer> map2 = new HashMap<>();
                List<Integer> resultList = new ArrayList<>();
                
                for (int num : nums1) {
                    map1.put(num, map1.getOrDefault(num, 0) + 1);
                }
                
                for (int num : nums2) {
                    if (map1.containsKey(num) && map1.get(num) > 0) {
                        resultList.add(num);
                        map1.put(num, map1.get(num) - 1);
                    }
                }
                
                int[] resultArray = new int[resultList.size()];
                for (int i = 0; i < resultList.size(); i++) {
                    resultArray[i] = resultList.get(i);
                }
                
                return resultArray;
            }
        }
     */
}
