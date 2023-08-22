package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }

    // 迭代方式
    /**
     * class Solution {
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> result = new LinkedList<>();
                if (root == null) {
                    return result;
                }
                
                Deque<TreeNode> stack = new ArrayDeque<>();
                stack.push(root);
                
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    result.add(0, node.val);
                    
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
                
                return result;
            }
        }
     */

}
