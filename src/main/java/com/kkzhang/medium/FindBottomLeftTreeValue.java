package com.kkzhang.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）来解决。
     * 我们可以按层遍历二叉树，每次遍历一层时，将该层最左边的节点值记录下来。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回0。
     * 2. 创建一个队列 queue，将根节点加入队列。
     * 3. 进入循环，当队列不为空时，执行以下操作：
     * * 3.1 获取当前层的节点数量 size。
     * * 3.2 遍历当前层的所有节点，对于每个节点，如果是该层的第一个节点，则将其值记录下来。
     * * 3.3 将节点的左子节点和右子节点加入队列。
     * 4. 返回最后记录的值。
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res = cur.val;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return res;
    }

}
