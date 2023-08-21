package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowelsOfAString {
    /**
     * 解题思路：
     * 这道题要求反转字符串中的元音字母，可以使用双指针的方法来解决。
     * 
     * 具体步骤如下：
     * 1. 将字符串转换成字符数组，方便修改字符。
     * 2. 使用两个指针 left 和 right 分别指向字符串的起始和末尾位置。
     * 3. 循环条件为 left < right，在循环中，分别找到 left 和 right 指向的字符是否为元音字母，如果是，则交换这两个字符。
     * 4. 移动指针 left 向右移动，移动指针 right 向左移动。
     * 5. 循环结束后，将字符数组转换回字符串并返回。
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            swap(chars, left, right);
            left++;
            right--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // private boolean isVowel2(char c){
    //     return "AEIOUaeiou".indexOf(c) != -1;
    // }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
