package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * 解题思路：
     * 对于二叉搜索树，前序遍历的第一个节点是根节点，然后是左子树的节点，最后是右子树的节点。
     * 根据这个特性，可以从前序遍历数组中逐个节点构建二叉搜索树。
     * 
     * 具体步骤如下：
     * 1. 使用递归的方式构建二叉搜索树。从前序遍历数组中取出第一个节点作为根节点。
     * 2. 从剩余的节点中找到第一个大于根节点值的节点，将其分为左子树的部分和右子树的部分。
     * 3. 递归地构建左子树和右子树。
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return convert(preorder, 0, preorder.length - 1);
    }

    // [left, right]
    private TreeNode convert(int[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[left]);
        // 找到第一个比 preorder[left] 大的索引
        int partition = partition(preOrder, left, right);
        root.left = convert(preOrder, left + 1, partition - 1);
        root.right = convert(preOrder, partition, right);

        return root;
    }

    private int partition(int[] preOrder, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (preOrder[i] > preOrder[left]) {
                return i;
            }
        }
        return right + 1;
    }
}
