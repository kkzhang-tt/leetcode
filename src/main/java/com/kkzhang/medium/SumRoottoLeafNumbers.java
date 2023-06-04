package com.kkzhang.medium;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
 */
public class SumRoottoLeafNumbers {
    /**
     * 解题思路：
     * 这道题可以使用深度优先搜索（DFS）来解决。从根节点开始进行深度优先搜索，每次遍历到一个节点，将当前路径的数字乘以 10
     * 并加上当前节点的值，得到从根节点到当前节点的路径表示的数字。如果当前节点是叶子节点，则将该路径表示的数字累加到结果中。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，则返回 0。
     * 2. 定义一个变量 sum，用于记录数字之和的结果。
     * 3. 调用辅助函数 dfs，参数为根节点和当前路径表示的数字。
     * 4. 在辅助函数 dfs 中，首先判断当前节点是否是叶子节点。如果是，则将当前路径表示的数字累加到 sum 中。
     * * 如果当前节点不是叶子节点，递归遍历其左子节点和右子节点，分别调用 dfs(node.left, path * 10 + node.val) 和
     * * dfs(node.right, path * 10 + node.val)。
     * 5. 返回最终的结果 sum。
     * 
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pre) {
        if (root.left == null && root.right == null) {
            return pre * 10 + root.val;
        }
        int sum = 0;
        if (root.left != null) {
            sum += dfs(root.left, pre * 10 + root.val);
        }
        if (root.right != null) {
            sum += dfs(root.right, pre * 10 + root.val);
        }
        return sum;
    }
}
