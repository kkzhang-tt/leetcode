package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABST {

    /**
     * 解题思路：
     * 对于二叉搜索树（BST），中序遍历的结果是一个递增的序列。因此，可以使用中序遍历来找到第 k 个最小的元素。
     * 
     * 中序遍历方法：
     * 1. 对二叉搜索树进行中序遍历，同时维护一个计数器，当计数器等于 k 时，返回当前遍历到的节点值。
     */
    int res = -1;
    int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        inorderTraversal(root, k);
        return res;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, k);
        index++;
        if (index == k) {
            res = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }
}
