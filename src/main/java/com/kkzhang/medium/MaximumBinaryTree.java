package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    /**
     * 解题思路：
     * 要构建最大二叉树，可以使用递归的方式。
     * 首先找到数组中的最大值，将其作为根节点，然后将数组分为左子数组和右子数组，分别构建左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 定义一个递归方法 constructMaximumBinaryTree，传入数组 nums 和两个索引 left 和
     * * * right，表示当前构建的二叉树的范围。
     * 2. 在 constructMaximumBinaryTree 方法中，如果 left > right，返回 null。
     * 3. 找到 nums 数组中 left 到 right 范围内的最大值和其索引，将最大值作为根节点的值，创建根节点。
     * 4. 递归构建左子树，范围是 left 到最大值索引减1。
     * 5. 递归构建右子树，范围是最大值索引加1到 right。
     * 6. 返回根节点。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        int partition = partition(nums, left, right);
        if (partition == -1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[partition]);
        root.left = construct(nums, left, partition - 1);
        root.right = construct(nums, partition + 1, right);
        return root;
    }

    private int partition(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int index = left, i = left;
        while (i <= right) {
            if (nums[i] > nums[index]) {
                index = i;
            }
            i++;
        }
        return index;
    }
}
