package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

    /**
     * 解题思路：
     * 这道题要恢复一个二叉搜索树中两个错误交换位置的节点。
     * 可以使用中序遍历的方法来解决。
     * * 在二叉搜索树中，中序遍历得到的节点值应该是递增的。
     * * 如果有两个节点被错误地交换了位置，那么在中序遍历时会出现两次递减的情况。
     * * 因此，可以使用中序遍历找到这两个递减的节点，然后交换它们的值。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历对二叉搜索树进行遍历，将遍历到的节点值存储在一个数组中。
     * 2. 遍历数组，找到第一个递减的节点（即前一个节点大于后一个节点的值）和最后一个递减的节点。
     * 3. 交换这两个节点的值。
     */

    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root);

        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        return;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);

        if (first == null && prev.val > node.val) {
            first = prev;
        }
        if (first != null && prev.val > node.val) {
            second = node;
        }

        prev = node;

        inorderTraversal(node.right);
    }

    // 下面思路是错的，在根据中序遍历的结果进行节点调整时
    // 虽然中序遍历结果是有序的，但是无法保证调整后的树是二叉搜索树
    // 如 [1,3,null,null,2] 按照下面思路调整会变成 [1,2,null,null,3]，但是这个结果不是二叉搜索树
    List<TreeNode> nodes = new ArrayList<>();

    public void recoverTree2(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal2(root);

        TreeNode first = null, second = null;
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode pre = nodes.get(i - 1);
            TreeNode cur = nodes.get(i);
            if (cur.val <= pre.val) {
                if (first == null) {
                    first = pre;
                } else {
                    second = cur;
                }
            }
        }

        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        return;
    }

    private void inorderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal2(root.left);
        nodes.add(root);
        inorderTraversal2(root.right);
    }
}
