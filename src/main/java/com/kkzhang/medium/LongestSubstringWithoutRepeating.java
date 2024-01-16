package com.kkzhang.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeating {

    /**
     * 解题思路：
     * 要找到一个字符串中不含有重复字符的最长子串的长度，可以使用滑动窗口的方法。
     * 
     * 具体步骤如下：
     * 1. 使用一个哈希集合来存储滑动窗口中的字符，初始时滑动窗口为空，哈希集合中也为空。
     * 2. 使用两个指针 left 和 right 表示滑动窗口的左边界和右边界，初始时都指向字符串的起始位置。
     * 3. 遍历字符串，不断移动右指针，将右指针指向的字符添加到哈希集合中，表示字符在滑动窗口中。
     * * * 如果遇到重复的字符，则将左指针指向的字符从哈希集合中移除，并将左指针向右移动一格，直到滑动窗口中没有重复字符为止。
     * 4. 在遍历过程中，维护一个变量 maxLen 来记录滑动窗口的最大长度。
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int length = 0;
        Set<Character> window = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!window.contains(c)) {
                window.add(c);
                length = Integer.max(length, right - left + 1);
                right++;
            } else {
                char l = s.charAt(left);
                window.remove(l);
                left++;
            }

        }
        return length;
    }

    // re-post
    // 2024-01-16
    public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLen = 0;
        Set<Character> window = new HashSet<>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (!window.contains(cur)) {
                window.add(cur);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                while (window.contains(cur)) {
                    char leftChar = s.charAt(left);
                    window.remove(leftChar);
                    left++;
                }
            }
        }
        return maxLen;
    }

    // re-post
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int maxLength = 0, curLength = 0;
        Set<Character> window = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!window.contains(c)) {
                window.add(c);
                curLength = right - left + 1;
                maxLength = Math.max(maxLength, curLength);
                right++;
            } else {
                while (window.contains(c)) {
                    char l = s.charAt(left);
                    window.remove(l);
                    left++;
                }
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 0) {
            return 0;
        }
        // f[i] 表示以字符 s[i] 结尾的最长子序列
        // f[i] = f[i-1] + 1; 如果 s[i] 在 s[i-1] 最长子序列窗口内都没有出现过
        // f[i] = i-k; 如果 s[i] 在 s[i-1] 最长子序列窗口中出现，并且对应索引为 k
        int[] f = new int[n];
        Map<Character, Integer> map = new HashMap<>();
        f[0] = 1;
        int max = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < n; i++) {
            // 判断 s[i] 是否出现在 s[i-1] 的最长子序列窗口中
            Integer index = map.get(s.charAt(i));
            if (index != null && index <= i && index >= (i - f[i - 1])) {
                f[i] = i - index;
            } else {
                f[i] = f[i - 1] + 1;
            }
            // 更新 s[i] 对应元素的位置
            map.put(s.charAt(i), i);
            max = Math.max(f[i], max);
        }
        return max;
    }
}
