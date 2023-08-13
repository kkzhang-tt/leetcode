package com.kkzhang.medium;

import java.util.LinkedList;
import java.util.Queue;
import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
    /**
     * 解题思路：
     * 这道题需要一种特殊的层序遍历方法，用于计算每层的宽度。
     * 我们不仅遍历每一层的节点，还需要为每个节点分配一个唯一的索引，从左到右，索引从1开始。
     * 对于每一层，我们记录第一个和最后一个节点的索引，然后计算宽度。
     * 
     * 具体步骤如下：
     * 1. 如果树为空，返回0。
     * 2. 创建一个队列 queue，用于层序遍历，将根节点加入队列。
     * 3. 创建一个队列 indexQueue，用于存储节点的索引，将1加入队列。
     * 4. 初始化变量 maxWidth 为0。
     * 5. 进入循环，当队列不为空时，执行以下操作：
     * * 5.1 获取当前层的节点数量 size。
     * * 5.2 初始化变量 start 为0，end 为0。
     * * 5.3 遍历当前层的所有节点，对于每个节点，将其索引出队，并将其索引保存到 end 中。
     * * * * 如果是该层的第一个节点，则将其索引保存到 start 中。
     * * 5.4 更新 maxWidth，计算宽度为 end - start + 1。
     * * 5.5 将当前层的子节点以及子节点的索引加入队列和 indexQueue。
     * 6. 返回 maxWidth。
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if (root == null) {
            return maxWidth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // 用于存储每一层节点的索引
        // 把该二叉树看作完全二叉树，为每个节点分配索引
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                Integer curIndex = indexQueue.poll();

                // 当前层最左边的节点
                if (i == 0) {
                    left = curIndex;
                }
                // 当前层最右边的节点
                if (i == size - 1) {
                    right = curIndex;
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    // 左节点是其父节点索引的 2 倍
                    indexQueue.offer(curIndex * 2);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    // 右节点是其父节点索引的 2 倍 + 1
                    indexQueue.offer(curIndex * 2 + 1);
                }
            }
            maxWidth = Integer.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }
}
