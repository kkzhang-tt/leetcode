package com.kkzhang.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeating {

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
