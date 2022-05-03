package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {
    // f[i] 表示以 i 结尾的最长子序列；pre[i] 表示以 i 结尾的最长子序列的前一个元素索引
    // f[i] = max{f[j]} + 1, 其中 0 <= j <= i, nums[i] % nums[j] == 0
    // 该题的难点在于如何构造返回序列，借助 pre[] 数组
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        f[0] = 1;
        pre[0] = -1;
        int largest = 1;
        int largestIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            int curMax = 1;
            int preIndex = -1;
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && f[j] + 1 > curMax) {
                    curMax = f[j] + 1;
                    preIndex = j;
                }
            }
            f[i] = Math.max(curMax, f[i]);
            pre[i] = preIndex;

            if (largest < f[i]) {
                largest = f[i];
                largestIndex = i;
            }
        }

        while (largestIndex != -1) {
            res.add(nums[largestIndex]);
            largestIndex = pre[largestIndex];
        }
        return res;
    }

    // 回溯：子集树
    // 超时
    public List<Integer> largestDivisibleSubset_1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        List<List<Integer>> allRes = new ArrayList<>();
        backtrack(nums, 0, curList, allRes);
        for (List<Integer> list : allRes) {
            if (list.size() > res.size()) {
                res = list;
            }
        }
        return res;
    }

    private void backtrack(int[] nums, int curLevel, List<Integer> curList, List<List<Integer>> res) {
        if (curLevel >= nums.length) {
            res.add(new ArrayList<>(curList));
        } else {
            // 0: 不取
            backtrack(nums, curLevel + 1, new ArrayList<>(curList), res);
            // 1: 取
            if (curList.size() > 0) {
                int last = curList.get(curList.size() - 1);
                if (nums[curLevel] % last == 0) {
                    curList.add(nums[curLevel]);
                }
            } else {
                curList.add(nums[curLevel]);
            }
            backtrack(nums, curLevel + 1, new ArrayList<>(curList), res);
        }
    }
}
