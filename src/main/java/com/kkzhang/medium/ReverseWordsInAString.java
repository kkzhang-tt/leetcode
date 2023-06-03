package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&id=top-interview-150
 */
public class ReverseWordsInAString {
    /**
     * 解题思路：
     * 题目要求逐个翻转字符串中的每个单词。可以通过先将字符串整体翻转，再逐个翻转每个单词的方式来实现。
     * 
     * 具体步骤如下：
     * 1. 将输入字符串去除首尾多余的空格，并转换为字符数组。
     * 2. 对整个字符数组进行翻转，即将整个字符串倒序排列。
     * 3. 定义变量start和end，分别表示当前单词的起始位置和结束位置。
     * 4. 遍历字符数组，对于每个字符：
     * * 如果当前字符是空格，并且start不等于end，表示找到一个单词，将该单词翻转。
     * * 更新start为下一个单词的起始位置。
     * * 更新end为下一个单词的结束位置。
     * 5. 最后一个单词无法在循环中处理到，因此单独将最后一个单词翻转。
     * 6. 将字符数组转换为字符串并返回。
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.trim().toCharArray();
        reverse(chars, 0, chars.length -1);

        int start = 0;
        int end = 0;

        while (end < chars.length) {
            if (chars[end] == ' ') {
                if (start != end) {
                    reverse(chars, start, end - 1);
                }
                start = end + 1;
            }
            end++;
        }

        reverse(chars, start, end - 1);

        return new String(chars);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            
            start++;
            end--;
        }
    }
}
