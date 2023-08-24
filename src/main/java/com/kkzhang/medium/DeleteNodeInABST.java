package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABST {

    /**
     * 解题思路：
     * 删除一个节点分为以下几种情况：
     * 1. 节点为叶子节点：直接删除即可。
     * 2. 节点有一个子节点：将子节点替代当前节点。
     * 3. 节点有两个子节点：需要找到右子树的最小节点（或左子树的最大节点），将其值赋给当前节点，然后递归删除右子树的最小节点。
     * 4. 对于二叉搜索树，要删除一个节点并保持二叉搜索树的性质，可以通过递归进行。
     * 
     * 具体步骤如下：
     * 1. 如果节点为空，直接返回空。
     * 2. 如果 key 小于当前节点的值，则递归处理左子树。
     * 3. 如果 key 大于当前节点的值，则递归处理右子树。
     * 4. 如果 key 等于当前节点的值，则根据情况删除节点：
     * 5. 如果节点为叶子节点或只有一个子节点，直接返回其子节点。
     * 6. 如果节点有两个子节点，找到右子树的最小节点，将其值赋给当前节点，然后递归删除右子树的最小节点。
     * 
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            int min = findMin(root.right);
            root.val = min;
            root.right = deleteNode(root.right, min);
            return root;
        }

        return root;
    }

    private int findMin(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
