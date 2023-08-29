package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    /**
     * 解题思路：
     * 二叉树的直径可以看作是树中任意两个节点之间的最长路径。
     * 这个路径可能经过根节点，也可能不经过。
     * 所以，我们需要遍历每个节点，找出以每个节点为根的子树的最大直径，然后求所有子树的最大直径中的最大值。
     * 对于每个节点，可以通过计算它的左子树高度和右子树高度之和来得到以该节点为根的子树的最大直径。
     * 
     * 具体步骤如下：
     * 1. 定义一个变量 maxDiameter 来保存最大直径。
     * 2. 调用 dfs 方法进行深度优先搜索，传入根节点和 maxDiameter。
     * 3. 在 dfs 方法中，如果当前节点为空，返回0。
     * 4. 递归计算左子树高度和右子树高度。
     * 5. 更新 maxDiameter，取当前节点的左子树高度和右子树高度之和与 maxDiameter 的较大值。
     * 6. 返回当前节点的高度，即左子树高度和右子树高度中的较大值加1。
     * 7. 遍历结束后，maxDiameter 即为二叉树的直径。
     */
    int maxLength = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDepth(root);
        return maxLength;
    }

    // 也可以看作后序遍历
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxLength = Integer.max(maxLength, left + right);

        return Math.max(left, right) + 1;
    }
}
