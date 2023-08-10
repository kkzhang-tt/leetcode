package com.kkzhang.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    /**
     * 解题思路：
     * 这道题可以使用滑动窗口的方法来解决。
     * 滑动窗口是一种在数组或字符串上进行迭代的方法，可以通过两个指针来定义一个窗口，然后根据问题的要求，移动窗口的起始位置或结束位置。
     * 在这道题中，我们可以使用两个指针 left 和 right 来定义一个窗口，窗口内包含了字符串 t 中的字符。
     * 
     * 具体步骤如下：
     * 1. 使用哈希表 need 来存储字符串 t 中每个字符出现的次数。
     * 2. 使用哈希表 window 来存储当前窗口内每个字符出现的次数。
     * 3. 使用两个指针 left 和 right 来定义窗口的左边界和右边界，初始值都为 0。
     * 4. 使用一个变量 match 来表示窗口内满足条件的字符个数。
     * 5. 使用两个变量 start 和 minLen 来记录最小子串的起始位置和长度，初始值都为 0。
     * 6. 进入循环，当 right 小于字符串 s 的长度时，执行以下操作：
     * * 6.1 如果 s[right] 在 need 中存在，将其加入 window 中，如果 window[s[right]] 的值等于
     * * need[s[right]] 的值，表示窗口内该字符满足条件，将 match 加一。
     * * 6.2 当 match 等于字符串 t 的长度时，表示窗口内满足条件的字符个数已经足够，可以尝试缩小窗口，找到最小子串。
     * * 6.3 计算当前窗口的长度，如果小于 minLen，更新 start 和 minLen 的值。
     * * 6.4 将 s[left] 从 window 中移除，如果移除后 window[s[left]] 的值小于 need[s[left]]
     * * 的值，表示窗口内该字符不再满足条件，将 match 减一。
     * * 6.5 将 left 右移一位，缩小窗口。
     * * 6.6 将 right 右移一位，扩大窗口。
     * 7. 循环结束后，如果找到了最小子串，根据 start 和 minLen，截取字符串 s 得到最小子串，返回该子串。
     * 
     */
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // init target
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (target.containsKey(c)) {
                target.put(c, target.get(c) + 1);
            } else {
                target.put(c, 1);
            }
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int match = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            // expend window
            char cur = s.charAt(right);
            right++;

            if (target.containsKey(cur)) {
                // unpdate window
                if (window.containsKey(cur)) {
                    window.put(cur, window.get(cur) + 1);
                } else {
                    window.put(cur, 1);
                }

                // campare
                if (window.get(cur).equals(target.get(cur))) {
                    match++;
                }
            }

            while (match == target.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // shrink window
                cur = s.charAt(left);
                left++;

                if (target.containsKey(cur)) {
                    // update window
                    if (window.get(cur).equals(target.get(cur))) {
                        match--;
                    }
                    window.put(cur, window.get(cur) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    // 滑动窗口
    // not solved
    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired
        // window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current
        // window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
