package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kkzhang.common.TreeNode;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */
public class MostFrequentSubtreeSum {

    Map<Integer, Integer> frequencyMap = new HashMap<>();
    int maxFrequency = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        subtreeSum(root);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            if (maxFrequency == frequency) {
                res.add(key);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    // 可以看作后序遍历
    private int subtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = subtreeSum(root.left);
        int right = subtreeSum(root.right);

        int curSum = root.val + left + right;
        int curFrequency = frequencyMap.getOrDefault(curSum, 0) + 1;
        frequencyMap.put(curSum, curFrequency);
        maxFrequency = Integer.max(maxFrequency, curFrequency);

        return curSum;
    }

    // chatgpt generation
    /**
     * 解题思路：
     * 要找出现次数最多的子树和，可以使用深度优先搜索（DFS）遍历二叉树的所有子树和，并使用哈希表来记录每个子树和出现的次数。
     * 
     * 具体步骤如下：
     * 1. 定义一个哈希表 sumCount 用于记录每个子树和出现的次数。
     * 2. 调用 dfs 方法进行深度优先搜索，传入根节点和 sumCount。
     * 3. 在 dfs 方法中，如果当前节点为空，返回0。
     * 4. 递归计算左子树和右子树的和，并将当前节点值、左子树和、右子树和相加作为当前子树和。
     * 5. 将当前子树和放入哈希表中，更新它的出现次数。
     * 6. 返回当前子树和。
     * 7. 遍历结束后，遍历哈希表，找到出现次数最多的子树和，并将它们放入结果集中。
     */
    /**
     * class Solution {
            public int[] findFrequentTreeSum(TreeNode root) {
                Map<Integer, Integer> sumCount = new HashMap<>();
                dfs(root, sumCount);
                
                int maxCount = 0;
                List<Integer> resultList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
                    int sum = entry.getKey();
                    int count = entry.getValue();
                    
                    if (count > maxCount) {
                        maxCount = count;
                        resultList.clear();
                        resultList.add(sum);
                    } else if (count == maxCount) {
                        resultList.add(sum);
                    }
                }
                
                int[] resultArray = new int[resultList.size()];
                for (int i = 0; i < resultList.size(); i++) {
                    resultArray[i] = resultList.get(i);
                }
                
                return resultArray;
            }
            
            private int dfs(TreeNode node, Map<Integer, Integer> sumCount) {
                if (node == null) {
                    return 0;
                }
                
                int leftSum = dfs(node.left, sumCount);
                int rightSum = dfs(node.right, sumCount);
                int subtreeSum = leftSum + rightSum + node.val;
                
                sumCount.put(subtreeSum, sumCount.getOrDefault(subtreeSum, 0) + 1);
                
                return subtreeSum;
            }
        }
     */
}
