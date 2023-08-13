package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberoOfProvinces {
    /**
     * 解题思路：
     * 这道题可以看作是求图中连通分量的数量。
     * 我们可以使用深度优先搜索（DFS）或广度优先搜索（BFS）来遍历每个人，并将其与其朋友建立连通关系。
     * 遍历整个矩阵，每当遇到一个未访问的人，将其与其朋友建立连通关系，然后递归或使用队列遍历该人的朋友，并标记为已访问。
     * 每当开始遍历一个新的人，朋友圈数量加1。
     * 
     * 具体步骤如下：
     * 1. 创建一个数组 visited，用于记录每个人是否已经访问过。
     * 2. 创建一个变量 count，用于记录朋友圈数量。
     * 3. 遍历整个矩阵，对于每个人，如果该人未访问过，则递归或使用队列遍历该人的朋友，并将他们标记为已访问。
     * 4. 每当开始遍历一个新的人，朋友圈数量加1。
     * 5. 返回朋友圈数量。
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] graph, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < graph.length; j++) {
            // graph[i][j] == 1 表示 i, j 是邻接结点
            if (!visited[j] && graph[i][j] == 1) {
                dfs(graph, visited, i);
            }
        }
    }
}
