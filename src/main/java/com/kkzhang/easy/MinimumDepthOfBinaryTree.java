package com.kkzhang.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）的方法来解决。
     * 我们可以使用一个队列来存储当前层的所有节点，然后不断从队列中取出节点，
     * 如果该节点是叶子节点，则直接返回当前层数作为最小深度。如果不是叶子节点，则将其非空子节点加入队列，继续遍历下一层。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回 0。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 初始化一个变量 depth，表示当前的层数，初始值为 1。
     * 4. 进入循环，当队列不为空时，执行以下操作：
     * * 4.1 获取当前层的节点数量 size。
     * * 4.2 遍历当前层的所有节点，对于每个节点，如果它是叶子节点，则直接返回当前层数 depth 作为最小深度。
     * * 4.3 如果不是叶子节点，将其非空子节点加入队列。
     * * 4.4 遍历完当前层的所有节点后，将 depth 加 1。
     * 5. 如果在循环结束后没有找到叶子节点，则返回 0。
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(root);
        visited.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 此时遇到的叶子结点是第一次遇到，因此此时 depth 为最小
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepth2(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        depth++;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
