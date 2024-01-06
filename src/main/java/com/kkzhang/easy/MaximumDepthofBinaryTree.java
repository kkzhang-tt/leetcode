package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaximumDepthofBinaryTree {
    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。树的最大深度等于根节点的最大子树深度加上1。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回深度0。
     * 2. 递归计算左子树的最大深度，即调用 maxDepth(root.left)。
     * 3. 递归计算右子树的最大深度，即调用 maxDepth(root.right)。
     * 4. 返回左子树和右子树最大深度的较大值加上1。
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    
}
