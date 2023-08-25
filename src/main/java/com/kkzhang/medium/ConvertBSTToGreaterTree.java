package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBSTToGreaterTree {
    /**
     * 解题思路：
     * 对于二叉搜索树，可以通过中序遍历的方式，
     * 先遍历右子树再遍历左子树，然后累加计算每个节点的值。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历的方式遍历二叉搜索树。
     * 2. 在遍历每个节点时，累加计算节点的值，将累加结果赋给节点，并更新累加和变量。
     * 3. 递归处理右子树，再处理左子树。
     */
    int curSum = 0;

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return root;
        }
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.right);
        curSum += root.val;
        root.val = curSum;
        inorder(root.left);
    }

    // 1. 先遍历
    // 2. 再累计
    List<TreeNode> list = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        inorderTraversal(root);

        for (int i = list.size() - 2; i >= 0; i--) {
            TreeNode greater = list.get(i + 1);
            TreeNode cur = list.get(i);
            cur.val = cur.val + greater.val;
        }

        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }
}
