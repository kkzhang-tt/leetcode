package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNASequences {

    /**
     * 解题思路：
     * 这道题目要求寻找 DNA 字符串中所有长度为 10 的子串，这些子串中恰好出现次数大于等于 2 次。
     * 可以使用哈希表来记录出现次数，然后遍历字符串，将长度为 10 的子串加入到哈希表中，如果已经存在，则表示出现次数大于等于 2 次。
     * 
     * 具体步骤如下：
     * 1. 使用一个哈希表来记录子串出现的次数。
     * 2. 遍历 DNA 字符串，对于每个长度为 10 的子串，如果哈希表中已经有这个子串，将其加入到结果集中，然后将哈希表中对应的值加一。
     * 3. 遍历完成后，返回结果集。
     * 
     */
    // 窗口大小固定
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return result;
        }

        Set<String> window = new HashSet<>();
        int left = 0, right = 10;
        while (right <= s.length()) {
            String sub = s.substring(left, right);
            if (window.contains(sub) && !result.contains(sub)) {
                result.add(sub);
            } else {
                window.add(sub);
            }
            left++;
            right++;
        }

        return result;
    }
}
