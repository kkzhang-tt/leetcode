package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * 解题思路：
     * 根据先序和后序遍历构造二叉树，首先需要明确以下几点：
     * * 先序遍历的顺序是 根节点 -> 左子树 -> 右子树。
     * * 后序遍历的顺序是 左子树 -> 右子树 -> 根节点。
     * * 对于一个二叉树来说，它的先序遍历和后序遍历的序列是唯一确定的。
     * 根据上述特点，我们可以使用递归的方式构造二叉树。首先，根据先序遍历的第一个元素确定根节点，然后找到该元素在后序遍历中的位置，将序列分为左子树和右子树的部分，递归构造左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 定义一个递归方法 constructFromPrePost，传入两个数组 pre 和 post，以及左右边界。
     * 2. 如果 pre 和 post 的左边界大于右边界，说明当前子树为空，直接返回 null。
     * 3. 创建根节点，根节点的值为 pre[left]。
     * 4. 如果左边界小于右边界，找到 pre[left+1] 在 post 数组中的位置，将数组分为左子树和右子树的部分。
     * 5. 递归构造左子树和右子树，分别传入左子树的先序遍历和后序遍历序列以及右子树的先序遍历和后序遍历序列。
     * 6. 返回根节点。
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int i, int j, int[] postorder, int m, int n) {
        if (i > j || m > n) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        if (i == j) {
            return root;
        }
        int partition = partition(postorder, m, n - 1, preorder[i + 1]);
        int leftSize = partition - m + 1;
        root.left = construct(preorder, i + 1, i + leftSize, postorder, m, m + leftSize - 1);
        root.right = construct(preorder, i + leftSize + 1, j, postorder, partition + 1, n - 1);
        return root;
    }

    private int partition(int[] postorder, int m, int n, int v) {
        for (int i = m; i <= n; i++) {
            if (postorder[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
