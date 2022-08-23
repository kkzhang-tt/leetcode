package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // 区间范围索引，区间长度为 max-pre
        int pre = -1;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        // 记录每个元素最大索引
        Map<Character, Integer> indexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexes.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            int index = indexes.get(s.charAt(i));
            max = Math.max(index, max);
            if (i == max) {
                // 区间结束
                res.add(max - pre);
                pre = max;
            }
        }
        return res;
    }
}
