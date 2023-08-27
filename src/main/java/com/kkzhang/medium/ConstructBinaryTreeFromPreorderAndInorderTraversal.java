package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。
     * 前序遍历的第一个节点为根节点，在中序遍历中找到根节点的位置，
     * 根节点的左侧为左子树的中序遍历，根节点的右侧为右子树的中序遍历。
     * 然后分别在前序遍历的左侧和右侧部分递归构建左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 如果前序遍历数组或中序遍历数组为空，返回空节点。
     * 2. 从前序遍历数组中取出第一个元素作为根节点。
     * 3. 在中序遍历数组中找到根节点的位置，左侧部分为左子树的中序遍历，右侧部分为右子树的中序遍历。
     * 4. 递归地构建左子树和右子树。
     * 
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int m, int n) {
        if (i > j || m > n) {
            return null;
        }

        // 找到根节点在 inorder 的位置
        int rootVal = preorder[i];
        int partition;
        for (partition = m; partition <= n; partition++) {
            if (inorder[partition] == rootVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftLen = partition - m;
        // 根据根节点拆分数组
        root.left = buildTree(preorder, i + 1, i + leftLen, inorder, m, partition - 1);
        root.right = buildTree(preorder, i + leftLen + 1, j, inorder, partition + 1, n);

        return root;
    }
}
