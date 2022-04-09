package com.kkzhang.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    // f[i] 表示以 s[i] 结尾的子串能否进行 word break
    // f[i] = f[i-j] && s[i-j+1, i] 属于字典列表，其中 0<j<=i
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (wordDict.contains(subString) && f[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
