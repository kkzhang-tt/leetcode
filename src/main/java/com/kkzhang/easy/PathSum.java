package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class PathSum {
    /**
     * 解题思路：
     * 这道题可以使用递归的方法来解决。从根节点开始，计算当前节点到叶子节点的路径和，并与目标和进行比较。如果当前节点是叶子节点，并且路径和等于目标和，则返回
     * true。如果当前节点不是叶子节点，则递归判断其左子树和右子树是否存在满足条件的路径。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，则返回 false。
     * 2. 如果根节点是叶子节点，并且其值等于目标和，则返回 true。
     * 3. 递归判断左子树和右子树是否存在满足条件的路径，即调用 hasPathSum(root.left, targetSum - root.val) 和
     * hasPathSum(root.right, targetSum - root.val)。
     * 4. 如果左子树或右子树存在满足条件的路径，返回 true；否则返回 false。
     * 
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
