package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null){
            return root;
        }else if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return null;
        }
    }
}
