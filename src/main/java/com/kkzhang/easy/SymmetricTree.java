package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class SymmetricTree {
    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。如果一个二叉树是镜像对称的，那么它的左子树和右子树必须是镜像对称的。
     * 
     * 具体步骤如下：
     * 1. 定义一个辅助函数 isMirror，该函数判断两个节点是否是镜像对称的。
     * 2. 在 isMirror 函数中，判断两个节点是否都为空，如果是，则返回 true。
     * * 如果其中一个节点为空，另一个不为空，或者两个节点的值不相等，返回 false。
     * * 分别递归判断两个节点的左子节点和右子节点是否是镜像对称的，即调用 isMirror(left.left, right.right) 和
     * isMirror(left.right, right.left)。
     * * 如果左右子节点都镜像对称，返回 true；否则返回 false。
     * 3. 在主函数 isSymmetric 中，判断根节点是否为空，如果是，则返回 true。
     * 4. 调用辅助函数 isMirror(root.left, root.right)，判断左子树和右子树是否是镜像对称的。
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
