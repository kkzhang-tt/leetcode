package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    /**
     * 解题思路：
     * 这道题要判断一个二叉树是否是有效的二叉搜索树，可以使用递归或者中序遍历的方法来判断。
     * 
     * 递归方法：
     * 对于每个节点，需要判断它的值是否在其左子树的范围内（小于当前节点值）
     * 以及是否在其右子树的范围内（大于当前节点值）。
     * 在递归过程中，需要传递每个节点的值的上下界来判断。
     * 
     * 中序遍历方法：
     * 对于二叉搜索树，中序遍历的结果应该是一个递增的序列。
     * 因此，可以对二叉树进行中序遍历，将遍历到的节点值存储在一个数组中，然后判断数组是否是递增的。
     * 
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode cur, Integer lower, Integer upper) {
        if (cur == null) {
            return true;
        }
        int curVal = cur.val;
        if (lower != null && curVal <= lower) {
            return false;
        }
        if (upper != null && curVal >= upper) {
            return false;
        }
        if (!isValidBST(cur.left, lower, curVal)) {
            return false;
        }
        if (!isValidBST(cur.right, curVal, upper)) {
            return false;
        }
        return true;
    }

    // 测试用例 75/83
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null) {
            return root.left.val < root.val && root.right.val > root.val
                    && isValidBST2(root.left) && isValidBST2(root.right);
        } else if (root.left != null) {
            return root.left.val < root.val && isValidBST2(root.left);
        } else if (root.right != null) {
            return root.right.val > root.val && isValidBST2(root.right);
        } else {
            return true;
        }

    }
}
