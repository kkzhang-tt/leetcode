package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    // f[i] 表示跳到 i 位置需要的最少步数
    // f[i] = min(f[j] + 1), 其中 j + num[j] >= i && j < i
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }

}
