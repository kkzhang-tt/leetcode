package com.kkzhang.easy;

import javafx.scene.control.Hyperlink;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&id=top-interview-150
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    /**
     * 解题思路：
     * 题目要求实现一个算法，确定一个字符串是否是另一个字符串的子串，并返回子串的起始位置。可以使用滑动窗口的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 如果子串的长度大于字符串的长度，则直接返回 -1，因为子串无法是字符串的子串。
     * 2. 遍历字符串 s，从索引 0 到索引 s.length() - p.length()：
     * * 比较当前位置开始与子串 p 长度相等的子串与 p 是否相等，如果相等，则找到子串，并返回当前索引。
     * 3. 如果没有找到子串，则返回 -1。
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return -1;
        }

        for (int i = 0; i <= m - n; i++) {
            String sub = haystack.substring(i, i + n);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
