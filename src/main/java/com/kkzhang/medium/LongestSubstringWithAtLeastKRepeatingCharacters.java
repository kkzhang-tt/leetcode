package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * 解题思路：
     * 这道题要求找到一个字符串中最长的子串，要求该子串中的每个字符出现次数都不少于 k。
     * 可以使用分治法来解决。
     * 
     * 具体步骤如下：
     * 1. 遍历字符串，统计每个字符出现的次数，将字符和次数存储在一个哈希表中。
     * 2. 遍历字符串，对于每个字符，如果其出现次数小于 k，则说明该字符不可能出现在满足条件的子串中，可以以该字符为分界点，将字符串分成左右两部分，分别递归求解。
     * 3. 如果整个字符串都满足条件，则返回字符串的长度。
     * 4. 在递归求解过程中，返回左右两部分子串的最大长度。
     * 
     */
    public int longestSubstring(String s, int k) {
        return divideAndConquer(s, 0, s.length() - 1, k);
    }

    private int divideAndConquer(String s, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = left; i <= right; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = left; i <= right; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j <= right && count[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(divideAndConquer(s, left, i - 1, k), divideAndConquer(s, j, right, k));
            }
        }

        return right - left + 1;
    }
}
