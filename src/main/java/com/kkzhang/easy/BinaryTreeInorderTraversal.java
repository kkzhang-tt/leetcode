package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    /**
     * 解题思路：
     * 中序遍历是二叉树遍历的一种常用方法。
     * 它的遍历顺序是：先遍历左子树，然后遍历根节点，最后遍历右子树。
     * 
     * 递归方法：
     * 可以使用递归的方式来实现中序遍历。具体步骤如下：
     * 1. 若当前节点不为空，递归遍历它的左子树。
     * 2. 将当前节点的值添加到结果列表中。
     * 3. 若当前节点不为空，递归遍历它的右子树。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    List<Integer> inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversal(root.left, res);
            res.add(root.val);
            inorderTraversal(root.right, res);
        }
        return res;
    }
}
