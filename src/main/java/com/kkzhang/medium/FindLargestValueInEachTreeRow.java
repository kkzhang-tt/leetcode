package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）来解决。
     * 我们可以按层遍历二叉树，每次遍历一层时，找到该层的最大值，并将其记录下来。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 创建一个队列 queue，将根节点加入队列。
     * 3. 创建一个列表 result，用于存储每一层的最大值。
     * 4. 进入循环，当队列不为空时，执行以下操作：
     * * 4.1 获取当前层的节点数量 size。
     * * 4.2 初始化当前层的最大值 maxValue 为最小整数值。
     * * 4.3 遍历当前层的所有节点，对于每个节点，更新 maxValue 为当前节点值和 maxValue 中的较大值。
     * * 4.4 将节点的左子节点和右子节点加入队列。
     * * 4.5 将当前层的 maxValue 加入 result。
     * 5. 返回结果列表 result。
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                levelMax = Math.max(levelMax, cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(levelMax);
        }

        return result;
    }
}
