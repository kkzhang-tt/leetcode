package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

    /**
     * 解题思路：
     * 要计算整个二叉树的坡度，可以使用深度优先搜索（DFS）遍历二叉树，对每个节点计算其坡度，然后累加得到整个树的坡度。
     * 
     * 具体步骤如下：
     * 1. 调用 findTilt 方法进行搜索，传入根节点。
     * 2. 在 findTilt 方法中，如果当前节点为空，返回0。
     * 3. 递归计算左子树和右子树的节点值之和。
     * 4. 计算当前节点的坡度，即左子树节点值之和与右子树节点值之和的差的绝对值。
     * 5. 累加当前节点的坡度到结果变量 tilt 中。
     * 6. 返回当前节点的节点值之和。
     */
    int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return tilt;
    }

    // 节点遍历过程中计算坡度，但是 dfs 返回值是子树之和
    // 即 dfs 处理过程与返回值分开看待
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int curTilt = Math.abs(rightSum - leftSum);
        tilt += curTilt;

        return root.val + leftSum + rightSum;
    }
}
