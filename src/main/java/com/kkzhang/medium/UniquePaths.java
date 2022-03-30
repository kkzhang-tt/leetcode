package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    // f[i][j] 表示到达 [i,j] 位置的路径数
    // f[i][j] = f[i-1][j] + f[i][j-1]; 从 [i,j] 的左侧或者从上侧到达 [i,j]
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
