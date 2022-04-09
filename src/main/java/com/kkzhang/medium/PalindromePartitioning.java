package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    // 使用回溯找到所有的子串，限制条件：子串为回文串
    // 其解空间树为全排列树
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, 0, new ArrayList<>(), s);
        return res;
    }

    private void backtrack(List<List<String>> res, int curIndex, List<String> curRes, String s) {
        if (curIndex >= s.length()) {
            res.add(curRes);
        } else {
            // 以 curIndex 为起始点的子串取值可能为：[curIndex, curIndex + 1), [curIndex, curIndex + 2),
            // [curIndex, curIndex + 3) ... [curIndex, s.length)
            for (int i = curIndex; i < s.length(); i++) {
                String curString = s.substring(curIndex, i + 1);
                // 提前剪枝
                if (isPalindrome(curString)) {
                    curRes.add(curString);
                    backtrack(res, i + 1, new ArrayList<>(curRes), s);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
