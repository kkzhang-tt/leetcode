package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.kkzhang.common.TreeNode;

public class AverageOfLevelsInBinaryTree {

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）来解决。
     * 我们可以按层遍历二叉树，每次遍历一层时，计算该层节点值的平均值，并将其记录下来。
     * 
     * 具体步骤如下：
     * 1. 如果树为空，返回空列表。
     * 2. 创建一个队列 queue，将根节点加入队列。
     * 3. 创建一个列表 result，用于存储每一层节点值的平均值。
     * 4. 进入循环，当队列不为空时，执行以下操作：
     * * 4.1 获取当前层的节点数量 size。
     * * 4.2 初始化当前层节点值的和 sum 为0。
     * * 4.3 遍历当前层的所有节点，对于每个节点，将其值加到 sum 中。
     * * 4.4 计算平均值，将平均值加入 result。
     * * 4.5 将当前层的子节点加入队列。
     * 5. 返回结果列表 result。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 为了防止内存溢出，使用 double
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            double average = sum / size;
            result.add(average);
        }

        return result;
    }
}