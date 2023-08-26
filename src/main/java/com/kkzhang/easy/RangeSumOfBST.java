package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {

    /**
     * 解题思路：
     * 二叉搜索树的中序遍历结果是一个递增的序列。
     * 因此，可以通过中序遍历遍历二叉搜索树，
     * 然后在遍历的过程中判断节点的值是否在给定范围 [low, high] 内，如果是，则累加到结果中。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历遍历二叉搜索树。
     * 2. 在遍历每个节点时，判断节点的值是否在给定范围 [low, high] 内，如果是，则累加到结果中。
     * 3. 继续遍历左子树和右子树。
     */
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorderTraversal(root, low, high);
        return sum;
    }

    private void inorderTraversal(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        // 提前剪枝（减少不必要遍历）
        if (root.val >= low) {
            inorderTraversal(root.left, low, high);
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // 提前剪枝（减少不必要遍历）
        if (root.val <= high) {
            inorderTraversal(root.right, low, high);
        }
    }
}
