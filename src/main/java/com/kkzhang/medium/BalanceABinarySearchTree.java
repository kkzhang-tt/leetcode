package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class BalanceABinarySearchTree {

    /**
     * 解题思路：
     * 要将一个二叉搜索树转化为平衡二叉搜索树，
     * 可以使用中序遍历得到有序数组，然后将有序数组中的元素构建平衡二叉搜索树。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历得到二叉搜索树的有序数组。
     * 2. 使用有序数组中间的元素作为根节点，左边部分的元素构建左子树，右边部分的元素构建右子树。
     * 3. 递归地处理左子树和右子树。
     */
    List<Integer> vals = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        inorderTraversal(root);
        return construct(vals, 0, vals.size() - 1);
    }

    private TreeNode construct(List<Integer> vals, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(vals.get(mid));
        root.left = construct(vals, left, mid - 1);
        root.right = construct(vals, mid + 1, right);

        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        vals.add(root.val);
        inorderTraversal(root.right);
    }
}
