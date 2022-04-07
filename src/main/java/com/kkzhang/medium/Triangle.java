package com.kkzhang.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    // f[i][j] 表示到达 [i,j] 位置的最小路径和
    // 只能从正上方或者左斜上方到达当前位置
    // f[i][j] = f[i-1][j-1] if(i == j)
    // f[i][j] = min{f[i-1][j], f[i-1][j-1]} + nums[i,j] if(i > j)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    f[i][j] = f[i - 1][j] + curRow.get(j);
                } else if (j == i) {
                    f[i][j] = f[i - 1][j - 1] + curRow.get(j);
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + curRow.get(j);
                }

            }
        }
        int minSum = f[n - 1][0];
        for (int i = 0; i < n; i++) {
            minSum = Math.min(f[n - 1][i], minSum);
        }
        return minSum;
    }
}
