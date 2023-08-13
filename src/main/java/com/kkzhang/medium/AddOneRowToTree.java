package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {

    /**
     * 解题思路：
     * 这道题可以使用递归来解决。
     * 我们需要遍历树的每个节点，当遍历到深度 d-1 时，将其左子节点和右子节点修改为新的值 v。
     * 
     * 具体步骤如下：
     * 1. 如果树为空，直接返回。
     * 2. 如果深度 d 为1，说明我们要修改的是根节点，直接创建一个新的根节点，值为 v，并将原来的根节点作为新根节点的左子节点。
     * 3. 否则，递归遍历树，遍历到深度 d-1 时，将左子节点和右子节点修改为新的值 v。
     * 
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        traverse(root, val, depth, 1);
        return root;
    }

    private void traverse(TreeNode node, int val, int tarDepth, int curDepth) {
        if (node == null) {
            return;
        }

        if (tarDepth - 1 == curDepth) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            newLeft.left = left;
            newRight.right = right;

            node.left = newLeft;
            node.right = newRight;

            return;
        }

        traverse(node.left, val, tarDepth, curDepth + 1);
        traverse(node.right, val, tarDepth, curDepth + 1);
    }
}
