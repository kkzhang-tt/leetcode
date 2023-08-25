package com.kkzhang.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {

    /**
     * 解题思路：
     * 在二叉搜索树中，中序遍历的结果是一个递增的序列。
     * 因此，可以使用中序遍历来统计每个节点出现的次数，然后找到出现次数最多的元素（众数）。
     * 
     * 具体步骤如下：
     * 1. 使用中序遍历遍历二叉搜索树，同时使用一个哈希表来统计每个节点出现的次数。
     * 2. 遍历哈希表，找到出现次数最多的元素，将其添加到结果列表中。
     */
    Map<Integer, Integer> counter = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root);

        int maxCount = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int count = entry.getValue();
            int val = entry.getKey();
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(val);
            } else if (count == maxCount) {
                res.add(val);
            }
        }

        int[] arrays = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arrays[i] = res.get(i);
        }
        return arrays;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        counter.put(root.val, counter.getOrDefault(root.val, 0) + 1);
        inorderTraversal(root.right);
    }

    // chatgpt generation
    /**
     * class Solution {
            private Map<Integer, Integer> freqMap;
            private int maxFreq;
            
            public int[] findMode(TreeNode root) {
                freqMap = new HashMap<>();
                maxFreq = 0;
                inorder(root);
                
                List<Integer> modes = new ArrayList<>();
                for (int key : freqMap.keySet()) {
                    if (freqMap.get(key) == maxFreq) {
                        modes.add(key);
                    }
                }
                
                int[] result = new int[modes.size()];
                for (int i = 0; i < modes.size(); i++) {
                    result[i] = modes.get(i);
                }
                return result;
            }
            
            private void inorder(TreeNode node) {
                if (node == null) {
                    return;
                }
                
                inorder(node.left);
                
                freqMap.put(node.val, freqMap.getOrDefault(node.val, 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(node.val));
                
                inorder(node.right);
            }
        }
     */
}
