package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        // int n = nums.length;
        // if (n == 0) {
        //     return 0;
        // }
        // int[] f = new int[n + 1];
        // boolean[] b = new boolean[n + 1];
        // f[0] = 0;
        // b[0] = false;
        // f[1] = nums[0];
        // b[1] = true;
        // int max = f[1];
        // for (int i = 2; i < n + 1; i++) {
        //     int preMax = 0;
        //     int k = 0;
        //     if (i == n) {
        //         k = 2;
        //     }
        //     int preMaxIndex = -1;
        //     for (int j = i - 2; j >= k; j--) {
        //         if (i == n && b[j]) {
        //             continue;
        //         }
        //         preMax = Math.max(preMax, f[j]);
        //         preMaxIndex = j;
        //     }
        //     if (b[preMaxIndex]) {
        //         b[i] = true;
        //     }
        //     f[i] = preMax + nums[i - 1];
        //     max = Math.max(max, f[i]);
        // }
        // return max;
        return 0;
    }
}
