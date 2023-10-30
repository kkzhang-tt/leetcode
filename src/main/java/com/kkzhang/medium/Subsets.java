package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    // generated by chatgpt
    /**
     * 解题思路：
     * 这是一个组合问题，可以使用回溯法来解决。
     * 1. 首先，创建一个结果列表 result 用于存储所有可能的子集。
     * 2. 创建一个回溯函数 backtrack，接收当前位置 start，当前正在构建的子集 subset 作为参数。
     * 3. 在 backtrack 函数中，将当前子集 subset 添加到结果列表 result 中。
     * 4. 使用一个循环从 start 开始遍历数组 nums，在循环中，将当前元素添加到 subset 中，并递归调用 backtrack 函数，传入更新后的
     * start 和 subset。
     * 5. 递归结束后，需要将当前元素从 subset 中移除，以便下一轮的递归。
     * 6. 最终返回结果列表 result。
     */
    /**
     * import java.util.*;

        public class Subsets {
            public List<List<Integer>> subsets(int[] nums) {
                List<List<Integer>> result = new ArrayList<>();
                backtrack(0, new ArrayList<>(), nums, result);
                return result;
            }
            
            private void backtrack(int start, List<Integer> subset, int[] nums, List<List<Integer>> result) {
                result.add(new ArrayList<>(subset));
                
                for (int i = start; i < nums.length; i++) {
                    subset.add(nums[i]);
                    backtrack(i + 1, subset, nums, result);
                    subset.remove(subset.size() - 1);
                }
            }
        }
     */
}