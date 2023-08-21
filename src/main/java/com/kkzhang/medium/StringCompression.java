package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/string-compression/
 */
public class StringCompression {
    /**
     * 解题思路：
     * 这道题要求使用原地算法将重复的字符压缩，使每个字符只出现一次，并返回压缩后的长度。可以使用双指针的方法来实现。
     * 
     * 具体步骤如下：
     * 1. 使用两个指针 left 和 right 分别指向要处理的字符和将要压缩的位置。
     * 2. 初始化 count 为 1，表示当前字符的重复次数。
     * 3. 从第二个字符开始遍历数组，如果当前字符和前一个字符相同，则将 count 加一。
     * 4. 如果当前字符和前一个字符不同，表示已经统计完一个连续的字符序列，
     * * * 将 count 转换成字符串并压缩到 right 指向的位置，然后 right 移动到下一个位置。
     * 5. 遍历结束后，将最后一个字符的统计信息压缩到 right 指向的位置，然后返回 right。
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int index = 0;
        while (right < chars.length) {
            // 记录当前元素重复的起始与结束位置
            char cur = chars[left];
            while (right < chars.length && cur == chars[right]) {
                right++;
            }
            // 将当前元素的数目填充到 chars
            chars[index++] = cur;
            int count = right - left;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }

            left = right;
        }

        return index;
    }
}
