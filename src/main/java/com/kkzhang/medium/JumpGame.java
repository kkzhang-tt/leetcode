package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    // f[i] 表示能否跳到 i 位置
    // f[i] = true if (f[j] && j + num[j] >= i)
    // else f[i] = false
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return true;
        }
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && nums[j] + j >= i) {
                    f[i] = true;
                    break;
                } 
            }
        }
        return f[n - 1];
    }
}
