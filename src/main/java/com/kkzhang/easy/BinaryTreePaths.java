package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String prePath) {
        if (root == null) {
            return;
        }
        String curPath = prePath.isEmpty() ? prePath + root.val : prePath + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(new String(curPath));
        }
        if (root.left != null) {
            dfs(root.left, new String(curPath));
        }
        if (root.right != null) {
            dfs(root.right, new String(curPath));
        }
    }

    // chatgpt generation
    /**
     * 解题思路：
     * 这道题可以使用深度优先搜索（DFS）来遍历二叉树的所有路径。
     * 对于每个节点，将其值添加到当前路径中，然后递归遍历其左子树和右子树。当遍历到叶子节点时，将当前路径加入结果集。
     * 
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回空列表。
     * 2. 定义一个列表 path 来保存当前路径，一个列表 res 来保存结果集。
     * 3. 调用 dfs 方法进行深度优先搜索，传入根节点、当前路径和结果集。
     * 4. 在 dfs 方法中，如果当前节点是叶子节点，将当前路径转化为字符串并加入结果集。
     * 5. 否则，将当前节点的值加入到路径中，然后递归遍历左子树和右子树。
     * 6. 递归结束后，将当前节点从路径中移除。
     * * * 可以 new (path) 传递给下一层，但是会占用内存空间
     */
    /**
     * class Solution {
            public List<String> binaryTreePaths(TreeNode root) {
                List<String> res = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                dfs(root, path, res);
                return res;
            }
            
            private void dfs(TreeNode node, List<Integer> path, List<String> res) {
                if (node == null) {
                    return;
                }
                
                path.add(node.val);
                
                if (node.left == null && node.right == null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < path.size(); i++) {
                        sb.append(path.get(i));
                        if (i < path.size() - 1) {
                            sb.append("->");
                        }
                    }
                    res.add(sb.toString());
                } else {
                    dfs(node.left, path, res);
                    dfs(node.right, path, res);
                }
                
                path.remove(path.size() - 1);
            }
        }
     */
}
