package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class SameTree {
    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。如果两个二叉树的根节点值相等，并且它们的左子树和右子树也分别相等，则认为它们是相同的。
     * 
     * 具体步骤如下：
     * 1. 如果两个二叉树的根节点都为空，返回 true。
     * 2. 如果其中一个二叉树的根节点为空，另一个不为空，返回 false。
     * 3. 如果两个二叉树的根节点值不相等，返回 false。
     * 4. 分别递归判断两个二叉树的左子树是否相同，即调用 isSameTree(p.left, q.left)。
     * 5. 分别递归判断两个二叉树的右子树是否相同，即调用 isSameTree(p.right, q.right)。
     * 6. 如果左右子树都相同，则返回 true；否则返回 false。
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
