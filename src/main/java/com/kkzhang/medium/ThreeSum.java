package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    // 三指针方法
    // 第一个指针固定，其他两个指针左右移动来找到目标解
    public List<List<Integer>> threeSum_1(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 指针 i 固定
            // 指针 j, k 移动找到目标解
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> target = new ArrayList<>();
                    target.add(nums[i]);
                    target.add(nums[j]);
                    target.add(nums[k]);
                    res.add(target);
                    k--;
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    // 回溯法
    // 思路正确，但是部分 case 超时
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        backTrack(res, cur, nums, 3, 0);
        return construct(res);
    }

    /**
     * 解空间树为子集树
     */
    private void backTrack(Set<List<Integer>> res, List<Integer> cur, int[] nums, int max, int curLevel) {
        if (curLevel >= nums.length || cur.size() == max) {
            Collections.sort(cur);
            if (isValid(cur, max) && !res.contains(cur)) {
                res.add(cur);
            }
        } else {
            // 0: 不取当前元素
            backTrack(res, new ArrayList<>(cur), nums, max, curLevel + 1);
            // 1: 取当前元素
            cur.add(nums[curLevel]);
            backTrack(res, new ArrayList<>(cur), nums, max, curLevel + 1);
        }
    }

    private boolean isValid(List<Integer> list, int max) {
        if (list.size() != max) {
            return false;
        }
        int sum = 0;
        for (Integer v : list) {
            sum += v;
        }
        return sum == 0;
    }

    private List<List<Integer>> construct(Set<List<Integer>> set) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }
}
