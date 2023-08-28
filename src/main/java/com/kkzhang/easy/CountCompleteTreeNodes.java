package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return count;
        }
        inorderTraversal(root);
        return count;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        count++;
        inorderTraversal(root.right);
    }

    // chatgpt generation
    /**
     * 解题思路：
     * 对于完全二叉树，可以分为两种情况：
     * 最后一层的节点数等于最大值，此时树是满二叉树。
     * 最后一层的节点数少于最大值，此时树的左子树是满二叉树，右子树是一个比较小的完全二叉树。
     * 根据以上性质，可以使用递归的方法来解决。首先计算左子树的高度和右子树的高度，如果左子树的高度等于右子树的高度，说明左子树是满二叉树，可以直接通过公式计算节点个数。如果左子树的高度大于右子树的高度，说明右子树是一个比较小的完全二叉树，可以递归计算右子树的节点个数。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回0。
     * 2. 计算左子树的高度和右子树的高度。
     * 3. 如果左子树的高度等于右子树的高度，说明左子树是满二叉树，节点个数为 2^leftHeight - 1。
     * 4. 如果左子树的高度大于右子树的高度，说明右子树是一个比较小的完全二叉树，递归计算右子树的节点个数。
     * 5. 返回节点个数。
     */
    /**
     * class Solution {
            public int countNodes(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                
                int leftHeight = getHeight(root.left);
                int rightHeight = getHeight(root.right);
                
                if (leftHeight == rightHeight) {
                    return (1 << leftHeight) + countNodes(root.right);
                } else {
                    return (1 << rightHeight) + countNodes(root.left);
                }
            }
            
            private int getHeight(TreeNode node) {
                if (node == null) {
                    return 0;
                }
                return 1 + getHeight(node.left);
            }
        }
     */
}
