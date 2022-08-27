package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    // two pointers
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            while (l < s.length() && !isCharacter(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !isCharacter(s.charAt(r))) {
                r--;
            }
            if (l >= r) {
                return true;
            } else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
