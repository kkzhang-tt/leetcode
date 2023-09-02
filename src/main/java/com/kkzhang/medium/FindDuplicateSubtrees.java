package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {

    /**
     * 解题思路：
     * 要找到所有重复的子树，可以使用深度优先搜索（DFS）遍历二叉树，然后对每个节点计算其子树的唯一标识（可以使用前序遍历或后序遍历）。
     * 如果两个节点的子树标识相同，则表示它们是重复的子树。
     * 
     * 具体步骤如下：
     * 1. 定义一个哈希表 subtreeCount 用于记录每个子树的出现次数。
     * 2. 调用 findDuplicateSubtrees 方法进行深度优先搜索，传入根节点和结果集。
     * 3. 在 findDuplicateSubtrees 方法中，如果当前节点为空，返回一个空字符串作为标识。
     * 4. 递归计算左子树和右子树的标识。
     * * 4.1 将当前节点的值、左子树的标识和右子树的标识连接起来，作为当前子树的唯一标识。
     * * 4.2 将当前子树的标识放入哈希表中，更新它的出现次数。
     * * 4.3 如果当前子树的出现次数为2，将当前节点加入结果集。
     * * 4.4 返回当前子树的标识。
     */
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return res;
        }
        postorderTraversal(root, new HashMap<>());
        return res;
    }

    // 关键还是在于遍历过程的返回值是什么
    private String postorderTraversal(TreeNode root, Map<String, Integer> counter) {
        if (root == null) {
            return "#";
        }
        String left = postorderTraversal(root.left, counter);
        String right = postorderTraversal(root.right, counter);

        String cur = left + "-" + root.val + "-" + right;
        counter.put(cur, counter.getOrDefault(cur, 0) + 1);
        if (counter.get(cur) == 2) {
            res.add(root);
        }

        return cur;
    }
}
