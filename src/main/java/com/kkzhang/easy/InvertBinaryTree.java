package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class InvertBinaryTree {

    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。对于每个节点，我们交换它的左右子节点，然后递归翻转左子树和右子树。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回 null。
     * 2. 交换根节点的左右子节点。
     * 3. 递归翻转左子树，即调用 invertTree(root.left)。
     * 4. 递归翻转右子树，即调用 invertTree(root.right)。
     * 5. 返回根节点。
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
