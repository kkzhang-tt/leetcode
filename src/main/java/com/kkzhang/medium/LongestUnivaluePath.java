package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {

    /**
     * 解题思路：
     * 要找到最长的同值路径，可以使用深度优先搜索（DFS）遍历二叉树，然后对每个节点，计算以该节点为根的同值路径长度。
     * 
     * 具体步骤如下：
     * 1. 调用 longestUnivaluePath 方法进行搜索，传入根节点。
     * 2. 在 longestUnivaluePath 方法中，如果当前节点为空，返回0。
     * 3. 递归计算左子树和右子树的同值路径长度。
     * 4. 如果当前节点值等于左子树的值，将左子树的同值路径长度加1，否则重置为0。
     * 5. 如果当前节点值等于右子树的值，将右子树的同值路径长度加1，否则重置为0。
     * 6. 更新最长同值路径长度，取左子树同值路径长度、右子树同值路径长度和当前节点左右子树同值路径长度之和的最大值。
     * 7. 返回当前节点的左右子树同值路径长度中的较大值。
     */
    int longest = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        univaluePath(root);
        return longest;
    }

    private int univaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = univaluePath(root.left);
        int right = univaluePath(root.right);

        // 如果当前值与左右节点值不同，则需要重置路径长度
        int leftPath = 0;
        int rightPath = 0;

        if (root.left != null && root.val == root.left.val) {
            leftPath = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightPath = right + 1;
        }

        longest = Math.max(longest, leftPath + rightPath);

        // 只需要返回左右子树中较长的路径即可，不需要将两者相加返回
        return Integer.max(leftPath, rightPath);
    }
}
