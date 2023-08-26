package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimABinarySearchTree {

    /**
     * 解题思路：
     * 对于二叉搜索树，可以使用递归的方法进行修剪。
     * 从根节点开始，递归地修剪左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，则返回空。
     * 2. 如果根节点的值小于 L，则修剪根节点的左子树，返回修剪后的右子树。
     * 3. 如果根节点的值大于 R，则修剪根节点的右子树，返回修剪后的左子树。
     * 4. 否则，递归修剪根节点的左子树和右子树，然后返回根节点。
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }

        return root;
    }
}
