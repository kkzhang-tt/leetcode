package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    /**
     * 解题思路：
     * 要判断一棵二叉树是否是高度平衡的，
     * 可以使用递归的方法来判断每个节点的左右子树的高度差是否不超过1，
     * 然后递归地判断每个节点的左子树和右子树是否也是高度平衡的。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回 true。
     * 2. 计算根节点的左子树和右子树的高度差，如果绝对值大于1，则返回 false。
     * 3. 递归判断根节点的左子树和右子树是否是高度平衡的。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.abs(left - right) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // chatgpt generation
    /**
     * class Solution {
            public boolean isBalanced(TreeNode root) {
                if (root == null) {
                    return true;
                }
                
                if (Math.abs(height(root.left) - height(root.right)) > 1) {
                    return false;
                }
                
                return isBalanced(root.left) && isBalanced(root.right);
            }
            
            private int height(TreeNode node) {
                if (node == null) {
                    return 0;
                }
                
                return Math.max(height(node.left), height(node.right)) + 1;
            }
        }
     */
}
