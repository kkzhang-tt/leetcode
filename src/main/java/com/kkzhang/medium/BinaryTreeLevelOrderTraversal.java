package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）的方法来解决。
     * 我们可以使用一个队列来存储每一层的节点，然后按层遍历二叉树，将每一层的节点值加入结果列表中。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 进入循环，当队列不为空时，执行以下操作：
     * * 3.1 获取当前层的节点数量 size。
     * * 3.2 初始化一个列表 curLevel，用于存储当前层的节点值。
     * * 3.3 遍历当前层的所有节点，对于每个节点，将其值加入 curLevel 中，并将其非空子节点加入队列。
     * * 3.4 遍历完当前层的所有节点后，将 curLevel 加入结果列表。
     * 4. 返回结果列表。
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
