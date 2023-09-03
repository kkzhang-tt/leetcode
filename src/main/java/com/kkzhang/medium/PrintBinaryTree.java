package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/print-binary-tree/
 */
public class PrintBinaryTree {

    /**
     * 解题思路：
     * 要输出二叉树，可以使用递归的方式，根据二叉树的高度和列数构建一个二维数组，并填充二叉树的节点值。
     * 
     * 
     * 具体步骤如下：
     * 1. 首先计算二叉树的高度，可以使用递归方法 getHeight 计算。
     * 2. 计算二叉树的列数，总是奇数，可以使用公式 2^height - 1 计算。
     * 3. 创建一个二维数组 result，大小为 height 行和 cols 列，初始值都设置为空字符串。
     * 4. 调用递归方法 fill，传入根节点、result 数组、当前层、当前列的起始索引和结束索引。
     * 5. 在 fill 方法中，首先计算当前层的中间位置 mid，然后将根节点的值放入 result 数组的 level 行的 mid 列。
     * 6. 递归调用 fill 方法分别处理左子树和右子树，左子树的列范围是 (start, mid - 1)，右子树的列范围是 (mid + 1, end)。
     * 7. 返回 result 数组作为最终结果。
     */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int rows = height(root);
        int cols = (1 << rows) - 1;

        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        preorderTraversal(root, res, 0, 0, cols - 1);
        return res;

    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(height(root.left), height(root.right));
    }

    private void preorderTraversal(TreeNode root, List<List<String>> res, int level, int left, int right) {
        if (root == null || level >= res.size()) {
            return;
        }
        int mid = left + (right - left) / 2;
        List<String> curRow = res.get(level);
        curRow.set(mid, String.valueOf(root.val));

        preorderTraversal(root.left, res, level + 1, left, mid - 1);
        preorderTraversal(root.right, res, level + 1, mid + 1, right);
    }
}
