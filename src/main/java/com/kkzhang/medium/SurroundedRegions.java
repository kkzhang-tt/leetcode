package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    /**
     * 解题思路：
     * 这道题可以使用深度优先搜索（DFS）或广度优先搜索（BFS）的方法来解决。
     * 我们可以从矩阵的边界开始，找到所有与边界上的 'O' 相连的区域，
     * 然后将这些区域标记为特定的标记，
     * 然后遍历整个矩阵，将没有被标记的 'O' 修改为 'X'，将特定标记的区域恢复为 'O'。
     * 
     * 具体步骤如下：
     * 1. 首先遍历矩阵的四条边，如果有 'O'，则以该点为起点进行深度优先搜索（DFS）或广度优先搜索（BFS），将与边界相连的 'O' 标记为特定标记（比如
     * 'B'）。
     * 2. 遍历整个矩阵，将没有被标记的 'O' 修改为 'X'，将特定标记的区域恢复为 'O'。
     */
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, visited, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, visited, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, visited, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }

        return;

    }

    private void dfs(char[][] board, int[][] visited, int i, int j) {
        if (visited[i][j] == 1) {
            return;
        }

        // visit the current node board[i][j]
        if (board[i][j] == 'X') {
            return;
        }
        visited[i][j] = 1;
        board[i][j] = 'S';

        // deal with the adjcent nodes
        if (i < board.length - 1) {
            dfs(board, visited, i + 1, j);
        }
        if (i > 0) {
            dfs(board, visited, i - 1, j);
        }
        if (j < board[0].length - 1) {
            dfs(board, visited, i, j + 1);
        }
        if (j > 0) {
            dfs(board, visited, i, j - 1);
        }
    }

    /**
     * ChatGPT generation
     * 
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) {
                return;
            }
            
            int rows = board.length;
            int cols = board[0].length;
            
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][cols - 1] == 'O') {
                    dfs(board, i, cols - 1);
                }
            }
            
            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j);
                }
                if (board[rows - 1][j] == 'O') {
                    dfs(board, rows - 1, j);
                }
            }
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == 'B') {
                        board[i][j] = 'O';
                    }
                }
            }
        }
        
        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }
            
            board[i][j] = 'B';
            
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
     */
}
