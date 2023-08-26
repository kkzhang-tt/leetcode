package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {

    boolean res = false;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root, new ArrayList<>(), k);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> vals, int k) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, vals, k);
        if (vals.contains(k - root.val)) {
            res = true;
            return;
        }
        vals.add(root.val);
        inorderTraversal(root.right, vals, k);
    }

    // chatgpt generation
    /**
     * 解题思路：
     * 由于给定的二叉搜索树是有序的，可以使用双指针的方式，
     * 分别从最小值和最大值开始遍历节点，判断两个节点的值之和是否等于目标值 k。
     * 
     * 具体步骤如下：
     * 1. 初始化两个指针，一个指向最小值（最左节点），一个指向最大值（最右节点）。
     * 2. 在每一次迭代中，判断两个指针所指向节点的值之和是否等于目标值 k。
     * 3. 如果两个节点的值之和小于目标值 k，将左指针指向下一个较大的节点。
     * 4. 如果两个节点的值之和大于目标值 k，将右指针指向下一个较小的节点。
     * 5. 如果左指针大于等于右指针，则停止遍历，返回 false。
     */
    /**
     * class Solution {
            public boolean findTarget(TreeNode root, int k) {
                if (root == null) {
                    return false;
                }
                
                Deque<TreeNode> leftStack = new ArrayDeque<>();
                Deque<TreeNode> rightStack = new ArrayDeque<>();
                
                pushLeft(root, leftStack);
                pushRight(root, rightStack);
                
                while (leftStack.peek() != rightStack.peek()) {
                    int sum = leftStack.peek().val + rightStack.peek().val;
                    
                    if (sum == k) {
                        return true;
                    } else if (sum < k) {
                        pushLeft(leftStack.pop().right, leftStack);
                    } else {
                        pushRight(rightStack.pop().left, rightStack);
                    }
                }
                
                return false;
            }
            
            private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            
            private void pushRight(TreeNode node, Deque<TreeNode> stack) {
                while (node != null) {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
     */
}
