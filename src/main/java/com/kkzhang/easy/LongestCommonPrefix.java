package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&id=top-interview-150
 */
public class LongestCommonPrefix {
    /**
     * 解题思路：
     * 题目要求查找字符串数组中的最长公共前缀。可以通过逐个比较字符的方式来找到最长公共前缀。
     * 
     * 具体步骤如下：
     * 1. 如果字符串数组为空或长度为0，则直接返回空字符串 ""。
     * 2. 初始化变量prefix为数组中的第一个字符串，作为初始的最长公共前缀。
     * 3. 遍历字符串数组，从第二个字符串开始：
     * * 如果当前字符串不以prefix开头，则从prefix的末尾逐渐减少字符，直到找到与当前字符串相匹配的前缀。
     * * 更新prefix为找到的匹配前缀。
     * * 如果prefix为空字符串，则表示没有公共前缀，直接返回 ""。
     * 4. 返回prefix作为最长公共前缀。
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            while (!cur.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
