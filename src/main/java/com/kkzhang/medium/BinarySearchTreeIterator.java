package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {
    /**
     * 解题思路：
     * 这道题要求实现一个二叉搜索树的迭代器，即在遍历过程中逐个输出节点的值。
     * 由于二叉搜索树的中序遍历是递增的，可以使用栈来辅助进行中序遍历。
     * 
     * 在初始化迭代器时，可以将根节点及其左子树的所有左子节点依次入栈。
     * 然后每次调用 next() 方法时，弹出栈顶节点，如果该节点有右子树，则将右子树及其左子树的所有左子节点依次入栈。
     */
    class BSTIterator {

        List<Integer> values = new ArrayList<>();
        int nextIndex = 0;

        public BSTIterator(TreeNode root) {
            inorderTraversal(root);
        }

        private void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            values.add(root.val);
            inorderTraversal(root.right);
        }

        public int next() {
            if (nextIndex < values.size()) {
                return values.get(nextIndex++);
            }
            return Integer.MAX_VALUE;
        }

        public boolean hasNext() {
            return nextIndex < values.size();
        }
    }

    // chagpt generation
    /**
     * class BSTIterator {
            private Deque<TreeNode> stack;

            public BSTIterator(TreeNode root) {
                stack = new ArrayDeque<>();
                TreeNode node = root;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            
            public int next() {
                TreeNode node = stack.pop();
                int val = node.val;
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                return val;
            }
            
            public boolean hasNext() {
                return !stack.isEmpty();
            }
        }

     */
}
