package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class SubsetsII {

    /**
     * 解题思路：
     * 这是一个组合问题，可以使用回溯法来解决。
     * 1. 首先，将数组 nums 进行排序，以便处理重复元素。
     * 2. 创建一个结果列表 result 用于存储所有可能的子集。
     * 3. 创建一个回溯函数 backtrack，接收当前位置 start，当前正在构建的子集 subset 作为参数。
     * 4. 在 backtrack 函数中，将当前子集 subset 添加到结果列表 result 中。
     * 5. 使用一个循环从 start 开始遍历数组 nums，在循环中，如果当前元素与前一个元素相等且当前位置不是 start，则跳过，以避免重复。
     * 6. 否则，将当前元素添加到 subset 中，并递归调用 backtrack 函数，传入更新后的 start 和 subset。
     * 7. 递归结束后，需要将当前元素从 subset 中移除，以便下一轮的递归。
     * 8. 最终返回结果列表 result。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            // 对于 start 之后的重复元素只选择一次
            // 但是 start 之前的重复元素可能会多次选择
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            backtrack(nums, i + 1, new ArrayList<>(cur), res);
            cur.remove(cur.size() - 1);
        }
    }
}
