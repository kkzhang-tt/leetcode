package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {
    // f[i][j] 表示以 matrix[i][j] 结尾的矩形边长
    // 如果 matrix[i][j] == '1', 则 f[i][j] 最少为 1
    // 如果 matrix[i][j] == '1' 并且 [i-1][j-1], [i][j-1], [i-1][j] 都为 '1'，
    // 那么 f[i][j] 就取这三个矩阵中最小边长 + 1
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] f = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                f[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                f[0][j] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    f[i][j] = 1;
                    if (f[i - 1][j - 1] > 0 && f[i - 1][j] > 0 && f[i][j - 1] > 0) {
                        f[i][j] = Math.min(Math.min(f[i - 1][j - 1], f[i - 1][j]), f[i][j - 1]) + 1;
                    }
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max * max;
    }
}
