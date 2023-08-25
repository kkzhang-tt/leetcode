package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {

    /**
     * 解题思路：
     * 二叉搜索树的插入操作可以通过递归实现。
     * 从根节点开始，根据插入值与当前节点值的大小关系，递归地向左子树或右子树搜索，直到找到一个空位置插入新节点。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，直接创建一个新节点并返回。
     * 2. 如果插入值小于当前节点值，则递归处理左子树，将返回的新节点作为当前节点的左子节点。
     * 3. 如果插入值大于当前节点值，则递归处理右子树，将返回的新节点作为当前节点的右子节点。
     * 4. 最后返回根节点。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
