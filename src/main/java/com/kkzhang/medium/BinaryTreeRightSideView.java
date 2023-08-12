package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）来解决。
     * 我们可以从根节点开始，按层遍历二叉树，并将每层最右边的节点值添加到结果列表中。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 进入循环，当队列不为空时，执行以下操作：
     * * 3.1 获取当前层的节点数量 size。
     * * 3.2 遍历当前层的所有节点，对于每个节点，将其值加入 level。
     * * 3.3 遍历完当前层的所有节点后，将 level 中最后一个值加入结果列表。
     * * 3.4 将节点的左子节点和右子节点加入队列。
     * 4. 返回结果列表。
     * 
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // keep the end node of the current level
                if (i == size - 1) {
                    result.add(cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return result;
    }
}
