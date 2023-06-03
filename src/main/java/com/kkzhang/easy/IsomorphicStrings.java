package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.Types;

/**
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsomorphicStrings {
    /**
     * 解题思路：
     * 该问题可以使用哈希表来解决。我们需要同时遍历字符串 s 和 t，并使用两个哈希表 sMap 和 tMap 来记录字符到字符的映射关系。
     * 
     * 具体步骤如下：
     * 1. 初始化两个哈希表 sMap 和 tMap。
     * 2. 遍历字符串 s 和 t 的每个字符：
     * * 获取当前字符 sChar 和 tChar。
     * * 如果 sMap 中不存在 sChar，则将 sChar 和 tChar 的映射关系存入 sMap。
     * * 如果 tMap 中不存在 tChar，则将 tChar 和 sChar 的映射关系存入 tMap。
     * * 如果 sMap 中的 sChar 与 tChar 不相等，或者 tMap 中的 tChar 与 sChar 不相等，返回 false。
     * 3. 遍历结束后，返回 true，表示字符串 s 和 t 是同构的。
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.get(sChar) == null) {
                sMap.put(sChar, tChar);
            } else if (tMap.get(tChar) == null) {
                tMap.put(tChar, sChar);
            } else {
                if (sMap.get(sChar) != tChar || tMap.get(tChar) != sChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
