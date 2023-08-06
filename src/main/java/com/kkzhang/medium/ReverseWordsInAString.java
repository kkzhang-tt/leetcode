package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&id=top-interview-150
 */
public class ReverseWordsInAString {

    /**
     * 解题思路：
     * 这道题要求对输入的字符串进行逐个单词翻转，同时删除前导和尾随空格，最终得到翻转后的字符串。
     * 由于要求使用 O(1) 额外空间复杂度的原地算法，所以我们需要在原字符串上进行操作，而不能使用额外的空间来辅助翻转。
     * 
     * 具体步骤如下：
     * 1. 将输入的字符串进行去除前导和尾随空格的处理。
     * 2. 对整个字符串进行逆序翻转。
     * 3. 对每个单词进行逆序翻转，即将每个单词的字符顺序进行翻转。
     * 4. 最后得到的字符串即为翻转后的结果。
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();

        int left = 0;
        int right = length - 1;
        // 移除左边空格
        while (left <= right && chars[left] == ' ') {
            left++;
        }
        // 移除右边空格
        while (right >= left && chars[right] == ' ') {
            right--;
        }

        // 反转整个字符串
        reverse(chars, left, right);

        int start = left;
        for (int i = left; i <= right; i++) {
            if (chars[i] == ' ') {
                // 反转当前单词
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }

        // 反转最后一个单词
        reverse(chars, start, right);

        return new String(chars, left, right - left + 1);
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
