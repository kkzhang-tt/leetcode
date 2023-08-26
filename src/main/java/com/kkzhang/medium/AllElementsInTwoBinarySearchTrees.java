package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {

    // 方案二：先遍历，再合并
    /**
     * 解题思路：
     * 将两个二叉搜索树中的元素按照中序遍历的方式得到有序数组，然后将两个有序数组合并成一个有序数组。
     * 
     * 具体步骤如下：
     * 1. 对两个二叉搜索树分别使用中序遍历，得到两个有序数组。
     * 2. 使用双指针的方式，将两个有序数组合并成一个有序数组。
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root2, list2);

        return merge(list1, list2);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();

        int index1 = 0, index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            int v1 = list1.get(index1);
            int v2 = list2.get(index2);
            if (v1 < v2) {
                res.add(v1);
                index1++;
            } else if (v1 == v2) {
                res.add(v1);
                res.add(v2);
                index1++;
                index2++;
            } else {
                res.add(v2);
                index2++;
            }
        }
        while (index1 < list1.size()) {
            res.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            res.add(list2.get(index2++));
        }
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // 方案一：先合并，再遍历（耗时较大）
    List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            inorderTraversal(root2);
        } else if (root2 == null) {
            inorderTraversal(root1);
        } else {
            merge(root1, root2);
            inorderTraversal(root2);
        }
        return res;
    }

    private void merge(TreeNode source, TreeNode target) {
        if (source == null) {
            return;
        }
        merge(source.left, target);
        insert(target, source.val);
        merge(source.right, target);
    }

    private TreeNode insert(TreeNode root, int v) {
        if (root == null) {
            return new TreeNode(v);
        }
        if (v >= root.val) {
            root.right = insert(root.right, v);
        } else {
            root.left = insert(root.left, v);
        }

        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    }
}
