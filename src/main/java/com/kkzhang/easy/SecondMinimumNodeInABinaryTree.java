package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return findGraterVal(root, root.val);
    }

    private int findGraterVal(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int left = findGraterVal(root.left, val);
        int right = findGraterVal(root.right, val);
        if (left > val && right > val) {
            return Integer.min(left, right);
        } else if (left > val) {
            return left;
        } else if (right > val) {
            return right;
        }
        return -1;
    }
}
