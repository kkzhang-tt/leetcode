package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // reverse tag
        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();

            // traverse current level
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (reverse) {
                Collections.reverse(curLevel);
            }
            result.add(curLevel);

            // reverse
            reverse = !reverse;
        }

        return result;
    }

    /**
     * 解题思路：
     * 这道题可以使用广度优先搜索（BFS）的方法来解决。
     * 我们可以使用一个队列来存储每一层的节点，然后根据当前层数的奇偶性来决定节点值的存储顺序。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 初始化一个队列，将根节点加入队列。
     * 3. 初始化一个变量 depth，表示当前层数，初始值为 0。
     * 4. 初始化一个列表 result，用于存储最终的锯齿形层序遍历结果。
     * 5. 进入循环，当队列不为空时，执行以下操作：
     * * 5.1 获取当前层的节点数量 size。
     * * 5.2 初始化一个列表 level，用于存储当前层的节点值。
     * * 5.3 遍历当前层的所有节点，对于每个节点，根据 depth 的奇偶性来决定将节点值加入 level 的头部或尾部。
     * * 5.5 遍历完当前层的所有节点后，将 level 加入 result。
     * * 5.6 将 depth 加一，表示进入下一层。
     * 6. 返回 result。
     * 
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            depth++;
        }

        return result;

    }

}
