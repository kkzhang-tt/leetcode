package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    /**
     * 解题思路：
     * 这道题可以使用深度优先搜索（DFS）或广度优先搜索（BFS）来解决。
     * 我们可以遍历整个二维网格，当遇到一个陆地（'1'）时，将其周围相邻的陆地都标记为已访问，并继续搜索相邻的陆地。
     * 每次搜索完成后，岛屿的数量加1。
     * 
     * 具体步骤如下：
     * 1. 创建一个函数 dfs，接受二维网格、行索引和列索引作为参数。
     * * 1.1 在该函数中，首先判断当前位置是否在网格范围内，如果不在范围内或者当前位置不是陆地（'1'），则直接返回。
     * * 1.2 将当前位置标记为已访问，然后递归调用 dfs 函数，分别访问上、下、左、右四个方向的位置。
     * 2. 遍历整个二维网格，每次遇到一个陆地（'1'），就调用 dfs 函数，然后岛屿数量加1。
     * 3. 返回岛屿数量。
     */
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int i, int j) {

        if (visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        if (i > 0) {
            dfs(grid, visited, i - 1, j);
        }
        if (i < grid.length - 1) {
            dfs(grid, visited, i + 1, j);
        }
        if (j > 0) {
            dfs(grid, visited, i, j - 1);
        }
        if (j < grid[0].length - 1) {
            dfs(grid, visited, i, j + 1);
        }
    }
}
