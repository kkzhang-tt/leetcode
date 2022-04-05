package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                curRow.add(1);
            } else if (i == 1) {
                curRow.clear();
                curRow.add(1);
                curRow.add(1);
            } else {
                // swap
                List<Integer> temp = lastRow;
                lastRow = curRow;
                curRow = temp;

                curRow.clear();
                curRow.add(1);
                for (int j = 1; j < i; j++) {
                    int curValue = lastRow.get(j) + lastRow.get(j - 1);
                    curRow.add(curValue);
                }
                curRow.add(1);
            }
        }
        return curRow;
    }
}
