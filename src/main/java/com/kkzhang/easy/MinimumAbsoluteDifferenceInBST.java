package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>();
        inOrderTraverse(root, nums);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            res = Math.min(res, nums.get(i) - nums.get(i - 1));
        }
        return res;
    }

    private void inOrderTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, res);
        res.add(root.val);
        inOrderTraverse(root.right, res);
    }

    // chatgpt generation

    int pre = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;

    /**
     * 解题思路：
     * 对于二叉搜索树（BST），中序遍历可以得到一个升序序列。
     * 因此，我们可以进行中序遍历，同时在遍历的过程中计算相邻节点值的差的最小值。
     * 
     * 具体步骤如下：
     * 1. 创建一个变量 prev 用于保存上一个遍历到的节点的值，初始化为最小整数值。
     * 2. 创建一个变量 minDiff 用于保存差的最小值，初始化为最大整数值。
     * 3. 进行中序遍历，遍历过程中执行以下操作：
     * * 3.1 如果当前节点不为空，递归遍历其左子树。
     * * 3.2 计算当前节点值与 prev 的差的绝对值，更新 minDiff。
     * * 3.3 将当前节点值赋给 prev。
     * * 3.4 递归遍历当前节点的右子树。
     * 4. 返回 minDiff。
     */
    public int getMinimumDifference2(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (pre == Integer.MAX_VALUE) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }

        inorder(root.right);
    }
}
