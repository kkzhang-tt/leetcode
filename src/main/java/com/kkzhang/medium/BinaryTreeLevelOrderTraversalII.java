package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * 这道题与102题（二叉树的层序遍历）相似
     * 不过在将每一层遍历结果添加到最终结果时，放在队列的头部，使最终结果反转。
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            // current level size
            int size = queue.size();
            // travese current level
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                // put the adjacent nodes into the queue
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(0, curLevel);
        }

        return result;
    }

    /**
     * 
     * 解题思路：
     * 这道题与102题（二叉树的层序遍历）相似，只需要在最后将结果列表翻转即可。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 进入循环，当队列不为空时，执行以下操作：
     * * 3.1 获取当前层的节点数量 size。
     * * 3.2 初始化一个列表 level，用于存储当前层的节点值。
     * * 3.3 遍历当前层的所有节点，对于每个节点，将其值加入 level。
     * * 3.4 遍历完当前层的所有节点后，将 level 加入结果列表。
     * 4. 返回结果列表的翻转。
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        Collections.reverse(result);
        return result;
    }
}
