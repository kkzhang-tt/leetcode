package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern {
    /**
     * 解题思路：
     * 该问题可以使用哈希表来解决。我们需要同时遍历 pattern 和 str，使用两个哈希表 patternMap 和 strMap 分别记录 pattern
     * 中字符到 str 单词和 str 单词到 pattern 字符的映射关系。
     * 
     * 具体步骤如下：
     * 1. 将 pattern 和 str 按空格分割成字符串数组 patternArr 和 strArr。
     * 2. 如果 patternArr 和 strArr 的长度不相等，返回 false。
     * 3. 遍历 patternArr 和 strArr 的每个单词：
     * * 获取当前单词 patternWord 和 strWord。
     * * 如果 patternMap 中不存在 patternWord，将 patternWord 和 strWord 的映射关系存入 patternMap。
     * * 如果 strMap 中不存在 strWord，将 strWord 和 patternWord 的映射关系存入 strMap。
     * * 如果 patternMap 中的 patternWord 与 strWord 不相等，或者 strMap 中的 strWord 与
     * patternWord 不相等，返回 false。
     * 4. 遍历结束后，返回 true，表示字符串 str 遵循规律 pattern。
     * 
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        String[] pattenArray = pattern.split("");

        if (sArray.length != pattenArray.length) {
            return false;
        }

        Map<String, String> sMap = new HashMap<>();
        Map<String, String> pMap = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            String pString = pattenArray[i];
            String sString = sArray[i];
            if (sMap.get(sString) == null) {
                sMap.put(sString, pString);
            }
            if (pMap.get(pString) == null) {
                pMap.put(pString, sString);
            }
            if (!sMap.get(sString).equals(pMap.get(pString)) || !pMap.get(pString).equals(sMap.get(sString))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        wordPattern(pattern, s);
    }

}
