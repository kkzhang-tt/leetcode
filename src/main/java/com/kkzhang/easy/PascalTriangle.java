package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    // 当前行的第 i 个元素 = 上一行第 i 个元素 + 上一行第 i-1 个元素
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            if (i == 0) {
                curRow.add(1);
            } else if (i == 1) {
                curRow.add(1);
                curRow.add(1);
            } else {
                // 第 i 行共有 i+1 个数字
                curRow.add(1);
                List<Integer> lastRow = res.get(i - 1);
                for (int j = 1; j < i; j++) {
                    int curValue = lastRow.get(j - 1) + lastRow.get(j);
                    curRow.add(curValue);
                }
                curRow.add(1);
            }
            res.add(curRow);
        }
        return res;
    }
}
