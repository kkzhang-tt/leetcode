package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumDistanceBetweenBSTNodes {

    /**
     * 解题思路：
     * 对于二叉搜索树，中序遍历得到的结果是一个递增的序列。
     * 因此，可以通过中序遍历遍历二叉搜索树，同时维护前一个遍历到的节点的值，
     * 计算当前节点与前一个节点的差的绝对值，找到最小的差值。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历遍历二叉搜索树。
     * 2. 在遍历每个节点时，计算当前节点与前一个节点的差的绝对值，并更新最小差值变量。
     * 3. 更新前一个节点的值。
     * 4. 继续遍历右子树。
     */
    int preVal = Integer.MIN_VALUE;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        if (preVal == Integer.MIN_VALUE) {
            preVal = root.val;
        } else {
            minDiff = Integer.min(root.val - preVal, minDiff);
            preVal = root.val;
        }

        inorderTraversal(root.right);
    }
}
