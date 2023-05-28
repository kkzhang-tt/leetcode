package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&id=top-interview-150
 */
public class LengthofLastWord {
    /**
     * 解题思路：
     * 题目要求计算给定字符串中最后一个单词的长度。
     * 可以通过从字符串末尾开始逆序遍历，找到最后一个单词的起始位置和结束位置，然后计算长度。
     * 
     * 具体步骤如下：
     * 1. 初始化变量length为0，表示最后一个单词的长度。
     * 2. 从字符串末尾开始逆序遍历，找到最后一个单词的结束位置。
     * * 先去除末尾的空格，直到遇到第一个非空格字符。
     * * 记录当前字符的索引为end。
     * * 继续往前遍历，直到遇到空格字符或到达字符串的开头。
     * 3. 继续往前遍历，找到最后一个单词的起始位置。
     * * 先去除起始位置处的空格，直到遇到第一个非空格字符。
     * * 记录当前字符的索引为start。
     * 4. 最后一个单词的长度等于end - start + 1。
     * 5. 返回最后一个单词的长度。
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }
}
