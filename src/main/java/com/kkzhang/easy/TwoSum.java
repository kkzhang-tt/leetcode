package com.kkzhang.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (map.containsKey(tar)) {
                res[0] = map.get(tar);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}