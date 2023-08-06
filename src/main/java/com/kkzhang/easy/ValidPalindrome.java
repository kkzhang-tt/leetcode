package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    /**
     * 解题思路：
     * 这道题可以使用双指针的方法来解决。
     * 我们可以分别设置两个指针 left 和 right，分别指向字符串的开头和结尾，然后不断向中间移动这两个指针，比较指向的字符是否相同。
     * 
     * 具体步骤如下：
     * 1. 初始化指针 left 为 0，指针 right 为字符串的长度减 1。
     * 2. 进入循环，当 left 小于 right 时，执行以下操作：
     * * 2.1 如果 left 指向的字符不是字母数字字符，将 left 右移一位。
     * * 2.2 如果 right 指向的字符不是字母数字字符，将 right 左移一位。
     * * 2.3 如果 left 和 right 都指向字母数字字符，比较这两个字符是否相同，如果不相同，则返回 false。
     * * 如果相同，将 left 右移一位，right 左移一位。
     * 3. 循环结束后，说明所有的字符都比较完毕，返回 true。
     * 
     */
    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            while (left <= right && !isCharacter(chars[left])) {
                left++;
            }
            while (left <= right && !isCharacter(chars[right])) {
                right--;
            }

            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

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
