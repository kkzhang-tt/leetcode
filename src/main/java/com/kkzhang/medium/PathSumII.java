package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preorderTraversal(root, targetSum, new ArrayList<>(), 0);
        return result;
    }

    private void preorderTraversal(TreeNode root, int target, List<Integer> preVals, int preSum) {
        if (root == null) {
            return;
        }

        preVals.add(root.val);
        preSum += root.val;

        if (root.left == null && root.right == null) {
            if (preSum == target) {
                result.add(preVals);
            }
            return;
        }

        preorderTraversal(root.left, target, new ArrayList<>(preVals), preSum);
        preorderTraversal(root.right, target, new ArrayList<>(preVals), preSum);
    }

    // chatgpt generation
    /**
     * 解题思路：
     * 可以使用深度优先搜索（DFS）来遍历二叉树的所有路径，并在遍历过程中计算路径的和。
     * 对于每个节点，可以将它添加到当前路径中，并将当前节点的值从目标和中减去，然后递归遍历左子树和右子树。
     * 当遍历到叶子节点时，如果目标和等于0，说明找到了一条路径，将这条路径加入结果集。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，返回空列表。
     * 2. 定义一个列表 path 来保存当前路径，一个列表 res 来保存结果集。
     * 3. 调用 dfs 方法进行深度优先搜索，传入根节点、目标和、当前路径和结果集。
     * 4. 在 dfs 方法中，如果当前节点为空，直接返回。
     * 5. 将当前节点的值加入到 path 中，将目标和减去当前节点的值。
     * 6. 如果当前节点是叶子节点且目标和为0，将当前路径 path 加入结果集 res。
     * 7. 递归遍历当前节点的左子树和右子树。
     * 8. 在递归结束后，将当前节点从 path 中移除，将目标和加上当前节点的值，返回上一层。
     * * * 这一步是为了不新建 path 对象，减少内存占用
     */
    /**
     * class Solution {
            public List<List<Integer>> pathSum(TreeNode root, int sum) {
                List<List<Integer>> res = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                dfs(root, sum, path, res);
                return res;
            }
            
            private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
                if (node == null) {
                    return;
                }
                
                path.add(node.val);
                sum -= node.val;
                
                if (node.left == null && node.right == null && sum == 0) {
                    res.add(new ArrayList<>(path));
                }
                
                dfs(node.left, sum, path, res);
                dfs(node.right, sum, path, res);
                
                path.remove(path.size() - 1);
            }
        }
     */
}
