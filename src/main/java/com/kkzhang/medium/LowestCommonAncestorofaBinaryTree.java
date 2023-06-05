package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。从根节点开始遍历二叉树，如果当前节点是 p 或 q，或者当前节点的左子树和右子树中分别包含 p 和
     * q，那么当前节点就是最近公共祖先。如果当前节点不是 p 或 q，且其左子树和右子树都不包含 p 和
     * q，那么最近公共祖先一定在当前节点的某一个子树中，需要递归进入子树继续寻找。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回 null。
     * 2. 如果根节点是 p 或 q，直接返回根节点。
     * 3. 递归遍历根节点的左子树和右子树，分别调用 lowestCommonAncestor(root.left, p, q) 和
     * * lowestCommonAncestor(root.right, p, q)。
     * 4. 如果左子树返回的结果不为空，且右子树返回的结果不为空，说明 p 和 q 分别位于根节点的左子树和右子树中，那么根节点就是最近公共祖先，直接返回根节点。
     * 5. 如果左子树返回的结果为空，说明 p 和 q 都不在左子树中，最近公共祖先一定在右子树中，返回右子树返回的结果。
     * 6. 如果右子树返回的结果为空，说明 p 和 q 都不在右子树中，最近公共祖先一定在左子树中，返回左子树返回的结果。
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
