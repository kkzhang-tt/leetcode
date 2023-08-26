package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BinarySearchTreeToGreaterSumTree {

    /**
     * 与 {@link #ConvertBSTToGreaterTree} 一样
     * https://leetcode.com/problems/convert-bst-to-greater-tree/
     *
     * 解题思路：
     * 对于二叉搜索树，可以通过中序遍历的方式，
     * 先遍历右子树再遍历左子树，然后累加计算每个节点的值。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历的方式遍历二叉搜索树。
     * 2. 在遍历每个节点时，累加计算节点的值，将累加结果赋给节点，并更新累加和变量。
     * 3. 递归处理右子树，再处理左子树。
     */
    int preSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        inorderTraversal(root);
        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.right);

        root.val += preSum;
        preSum = root.val;

        inorderTraversal(root.left);
    }
}
