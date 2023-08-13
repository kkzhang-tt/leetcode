package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += dfs(grid, visited, i, j);
                }
            }
        }

        return perimeter;
    }

    private int dfs(int[][] grid, int[][] visited, int i, int j) {
        if (visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;

        if (grid[i][j] == 0) {
            return 1;
        }
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            return 1;
        }

        int count = 0;
        if (i > 0) {
            count += dfs(grid, visited, i - 1, j);
        }
        if (i < grid.length - 1) {
            count += dfs(grid, visited, i + 1, j);
        }
        if (j > 0) {
            count += dfs(grid, visited, i, j - 1);
        }
        if (j < grid[0].length - 1) {
            count += dfs(grid, visited, i, j + 1);
        }

        return count;
    }
}
