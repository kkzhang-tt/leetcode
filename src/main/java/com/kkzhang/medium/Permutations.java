package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            backtrack(res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

}
