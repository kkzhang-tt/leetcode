package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 解题思路：
     * 由于二叉搜索树的性质，最近公共祖先的值必然位于 p 和 q 的值之间，即满足 p.val <= LCA.val <= q.val。
     * 
     * 可以通过以下步骤来解决这个问题：
     * 1. 从根节点开始遍历二叉树，如果当前节点的值大于 p 和 q 的值，说明 p 和 q 都在当前节点的左子树中，因此继续遍历当前节点的左子节点。
     * 2. 如果当前节点的值小于 p 和 q 的值，说明 p 和 q 都在当前节点的右子树中，因此继续遍历当前节点的右子节点。
     * 3. 如果当前节点的值介于 p 和 q 的值之间，或者等于 p 或 q 的值，则当前节点就是 p 和 q 的最近公共祖先。
     * 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    // 一般二叉树 LCA 解法（没问题）
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
