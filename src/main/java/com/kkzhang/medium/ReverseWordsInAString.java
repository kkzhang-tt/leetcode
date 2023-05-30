package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&id=top-interview-150
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length);

    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
        }
    }
}
