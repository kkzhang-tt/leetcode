package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    // f[i][j] 表示能够到达 [i,j] 的路径数
    // if obs[i,j] 位置有障碍，then f[i][j] = 0
    // if f[i-1][j] = 0 && f[i][j-1] = 0，then f[i][j] = 0；上侧跟左侧均不可达
    // if f[i-1][j] = 0, then f[i][j] = f[i][j-1]；上侧不可达
    // if f[i][j-1] = 0, then f[i][j] = f[i-1][j]；左侧不可达
    // else f[i][j] = f[i-1][j] + f[i][j-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        // init
        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || f[i - 1][0] == 0) {
                f[i][0] = 0;
            } else {
                f[i][0] = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1 || f[0][j - 1] == 0) {
                f[0][j] = 0;
            } else {
                f[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else if (f[i - 1][j] == 0 && f[i][j - 1] == 0) {
                    f[i][j] = 0;
                } else if (f[i - 1][j] == 0) {
                    f[i][j] = f[i][j - 1];
                } else if (f[i][j - 1] == 0) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
