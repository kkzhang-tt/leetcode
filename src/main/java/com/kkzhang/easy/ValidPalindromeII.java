package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

    // 最后几个 case 不通过
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int l = 0;
        int r = s.length() - 1;
        int deleteCount = 0;
        while (l <= r) {
            if (deleteCount > 1) {
                return false;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else if (l + 1 <= r && s.charAt(l + 1) == s.charAt(r)) {
                deleteCount++;
                l++;
            } else if (r - 1 >= l && s.charAt(l) == s.charAt(r - 1)) {
                deleteCount++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                // 跳过当前字符：跳过左边/右边
                // 有一侧满足回文即可
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
