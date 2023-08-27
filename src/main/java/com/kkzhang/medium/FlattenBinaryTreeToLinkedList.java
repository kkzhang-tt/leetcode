package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * 解题思路：
     * 展开二叉树为链表的顺序是前序遍历的顺序。
     * 要原地展开，可以从根节点开始，将其右子树移到左子树的最右边，
     * 然后将左子树移到根节点的右子树上，然后继续处理新的根节点的右子树，以此类推。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回。
     * 2. 对根节点的左子树进行展开。
     * 3. 对根节点的右子树进行展开。
     * 4. 将根节点的左子树移到右子树的位置，然后将根节点的左子树置为空。
     * 5. 将之前根节点的右子树（原来的左子树）移到现在右子树的最右边。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = tempRight;
    }
}
