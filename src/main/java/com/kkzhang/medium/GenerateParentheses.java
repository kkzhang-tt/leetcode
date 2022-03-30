package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    // 使用回溯法
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", 0, 0, n);
        return res;
    }

    private static void generateParenthesis(List<String> res, String cur, int open, int close, int n) {
        // 1. 第一个有效符号一定是 (
        // 2. ( 比 ) 少的时候提前剪枝
        // 3. ( ) 数目相等时一次遍历结束
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        
        // ( 可以一直加，直到数目为 n
        if (open < n) {
            generateParenthesis(res, cur + "(", open + 1, close, n);
        }
        //  这里提前对剪枝进行优化，跳过了 ( 小于 ) 的情况
        // ) 小于 ( 时，继续添加 )
        if (close < open) {
            generateParenthesis(res, cur + ")", open, close + 1, n);
        }
    }
}
