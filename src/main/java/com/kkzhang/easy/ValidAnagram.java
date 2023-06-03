package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidAnagram {
    /**
     * 解题思路：
     * 该问题可以通过对字符串进行排序来解决。如果两个字符串是有效的字母异位词，它们排序后的结果应该是相同的字符串。
     * 
     * 具体步骤如下：
     * 1. 将字符串 s 和 t 转换为字符数组 sChars 和 tChars。
     * 2. 对 sChars 和 tChars 进行排序。
     * 3. 将排序后的字符数组转换为字符串 sortedS 和 sortedT。
     * 4. 如果 sortedS 和 sortedT 相等，则返回 true，表示 s 和 t 是有效的字母异位词；否则返回 false。
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = sMap.getOrDefault(s.charAt(i), 1);
            sMap.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            int count = tMap.getOrDefault(t.charAt(i), 1);
            tMap.put(t.charAt(i), count + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (tMap.get(c) == null || tMap.get(c) != count) {
                return false;
            }
        }
        return true;
    }
}
