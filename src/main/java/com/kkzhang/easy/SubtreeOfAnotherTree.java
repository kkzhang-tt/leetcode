package com.kkzhang.easy;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

    /**
     * 解题思路：
     * 判断一个树是否是另一个树的子树，可以通过遍历原树的每个节点，对每个节点都进行一次判断是否与目标树相同。
     * 
     * 具体步骤如下：
     * 1. 调用 isSubtree 方法进行判断，传入原树的根节点和目标树的根节点。
     * 2. 在 isSubtree 方法中，如果原树的根节点为空，返回目标树的根节点是否为空的结果。
     * 3. 如果原树的根节点不为空，就判断当前节点是否与目标树的根节点相同，如果相同，就调用 isSameTree 方法来判断两个树是否相同。
     * 4. 如果当前节点不相同，就递归判断原树的左子树和右子树是否是目标树的子树。
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
