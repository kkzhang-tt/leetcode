package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode pre = null;
    TreeNode newRoot = null;

    public TreeNode increasingBST(TreeNode root) {
        inorderTraversal(root);
        return newRoot;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        increasingBST(root.left);

        TreeNode cur = new TreeNode(root.val);
        if (pre == null) {
            pre = cur;
            newRoot = cur;
        } else {
            pre.right = cur;
            pre = cur;
        }

        increasingBST(root.right);
    }

    /**
     * chatgpt generation
     * 
     * 解题思路：
     * 要将二叉搜索树转换为只有右子树的形式，
     * 可以通过中序遍历将节点的值按顺序存储在数组中，然后构建只有右子树的新树。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历将节点的值按顺序存储在数组中。
     * 2. 创建一个新树，根节点的值是数组的第一个值。
     * 3. 从数组的第二个值开始，依次将值作为右子节点添加到新树中。
     * 4. 返回新树的根节点。
     */
    /**
     * class Solution {
            public TreeNode increasingBST(TreeNode root) {
                List<Integer> inorder = new ArrayList<>();
                inorder(root, inorder);
                
                TreeNode newRoot = new TreeNode(0); // 创建一个哑节点
                TreeNode currNode = newRoot;
                
                for (int val : inorder) {
                    currNode.right = new TreeNode(val);
                    currNode = currNode.right;
                }
                
                return newRoot.right;
            }
            
            private void inorder(TreeNode node, List<Integer> inorder) {
                if (node == null) {
                    return;
                }
                
                inorder(node.left, inorder);
                inorder.add(node.val);
                inorder(node.right, inorder);
            }
        }
     */
}
