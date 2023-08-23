package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 解题思路：
     * 题目要求将有序整数数组转换为一棵高度平衡的二叉搜索树。
     * 由于数组是有序的，为了使得二叉搜索树高度平衡，可以选择数组的中间元素作为根节点，
     * 然后将数组分成左右两部分，分别递归构建左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 选择数组的中间元素作为当前子树的根节点，创建一个新的树节点。
     * 2. 将数组分成左右两部分，左边部分用于构建左子树，右边部分用于构建右子树。
     * 3. 递归地构建左子树和右子树。
     * 4. 返回根节点。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }

        int mid = i + (j - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, i, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, j);

        return root;
    }
}
