package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

public class SumOfLeftLeaves {

    /**
     * 解题思路：
     * 这道题可以使用深度优先搜索（DFS）来解决。
     * 我们可以从根节点开始遍历整个二叉树，当遇到一个左叶子节点时，将其值累加到结果中。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回0。
     * 2. 创建一个函数 dfs，接受一个节点 node 和一个布尔值 isLeft 作为参数。
     * * 2.1 如果当前节点为空，直接返回0。
     * * 2.2 如果当前节点是左叶子节点并且 isLeft 为真，则将其值累加到结果中。
     * * 2.3 递归调用 dfs 函数，分别遍历左子节点和右子节点。
     * * * * 对于左子节点，将 isLeft 设置为真；对于右子节点，将 isLeft 设置为假。
     * 3. 返回结果。
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        // visit and deal with the current node
        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }

        // deal with the adjacent nodes
        int sum = 0;
        if (node.left != null) {
            sum += dfs(node.left, true);
        }
        if (node.right != null) {
            sum += dfs(node.right, false);
        }

        return sum;
    }

}
