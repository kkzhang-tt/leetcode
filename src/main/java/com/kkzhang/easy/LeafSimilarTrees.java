package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

    /**
     * 解题思路：
     * 要判断两棵二叉树的叶子序列是否相同，可以使用深度优先搜索（DFS）遍历二叉树，并将叶子节点的值保存在一个列表中。
     * 然后比较两个列表是否相同。
     * 
     * 具体步骤如下：
     * 1. 定义一个递归方法 getLeafSequence，传入当前节点和一个列表 sequence，用于保存叶子节点的值。
     * 2. 在 getLeafSequence 方法中，如果当前节点为空，直接返回。
     * 3. 如果当前节点是叶子节点（即左右子节点都为空），将其值添加到 sequence 列表中。
     * 4. 递归调用 getLeafSequence 方法处理左子树和右子树。
     * 5. 调用 getLeafSequence 方法分别处理两棵树，得到它们的叶子序列。
     * 6. 比较两个叶子序列是否相同，如果相同返回 true，否则返回 false。
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> leaves1 = new ArrayList<>();
        inorderTraversal(root1, leaves1);

        List<Integer> leaves2 = new ArrayList<>();
        inorderTraversal(root2, leaves2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        int size = leaves1.size();
        for (int i = 0; i < size; i++) {
            int v1 = leaves1.get(i);
            int v2 = leaves2.get(i);
            if (v1 != v2) {
                return false;
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, leaves);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        inorderTraversal(root.right, leaves);
    }
}
