package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

    /**
     * 解题思路：
     * 这道题可以使用递归来解决。
     * 我们从根节点开始，依次递归合并两个二叉树的每个节点。
     * 
     * 具体步骤如下：
     * 1. 如果两个节点都为空，返回空节点。
     * 2. 如果其中一个节点为空，返回另一个节点。
     * 3. 创建一个新的节点，节点值为两个节点值的和。
     * * 3.1 递归合并左子树，将左子节点分别从两个二叉树中取出，递归调用合并函数。
     * * 3.2 递归合并右子树，将右子节点分别从两个二叉树中取出，递归调用合并函数。
     * 4. 返回新创建的节点。
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode root;
        if (root1 == null) {
            root = root2;
        } else if (root2 == null) {
            root = root1;
        } else {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }

        return root;

    }
}
