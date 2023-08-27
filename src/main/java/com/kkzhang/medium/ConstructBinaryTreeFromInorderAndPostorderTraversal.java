package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 解题思路：
     * 和前序遍历+中序遍历构造二叉树类似，这道题可以使用递归的方法来解决。
     * 后序遍历的最后一个节点为根节点，在中序遍历中找到根节点的位置，根节点的左侧为左子树的中序遍历，
     * 根节点的右侧为右子树的中序遍历。然后分别在后序遍历的左侧和右侧部分递归构建左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 如果中序遍历数组或后序遍历数组为空，返回空节点。
     * 2. 从后序遍历数组中取出最后一个元素作为根节点。
     * 3. 在中序遍历数组中找到根节点的位置，左侧部分为左子树的中序遍历，右侧部分为右子树的中序遍历。
     * 4. 递归地构建左子树和右子树。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }

        int rootVal = postorder[poEnd];
        int partition;
        for (partition = inStart; partition <= inEnd; partition++) {
            if (inorder[partition] == rootVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftLen = partition - inStart;
        root.left = buildTree(inorder, inStart, partition - 1, postorder, poStart, poStart + leftLen - 1);
        root.right = buildTree(inorder, partition + 1, inEnd, postorder, poStart + leftLen, poEnd - 1);

        return root;
    }
}
