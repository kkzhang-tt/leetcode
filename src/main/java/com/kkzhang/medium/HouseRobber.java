package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    // f[i] 表示抢劫第 i 家的最大值
    // f[i] = max{f[i-2], f[i-3], f[i-4] ... f[0]} + nums[i-1]
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = nums[0];
        int max = f[1];
        for (int i = 2; i < n + 1; i++) {
            int preMax = f[i - 2];
            for (int j = i - 2; j >= 0; j--) {
                preMax = Math.max(preMax, f[j]);
            }
            f[i] = preMax + nums[i - 1];
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
