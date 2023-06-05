package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    /**
     * 解题思路：
     * 这道题可以使用贪心算法来解决。
     * 我们从第一个位置开始，逐步更新能够到达的最远位置。
     * 如果最远位置超过了数组的最后一个下标，说明可以到达最后一个下标，返回 true。
     * 如果当前位置超过了最远位置，说明无法继续前进，返回 false。
     * 
     * 具体步骤如下：
     * 1. 定义一个变量 maxReach 来保存当前能够到达的最远位置，初始值为 0。
     * 2. 遍历数组 nums，对于每个位置 i，更新 maxReach 为 max(maxReach, i +
     * nums[i])，表示当前位置能够到达的最远位置。
     * 3. 在遍历过程中，如果 maxReach 大于等于数组的最后一个下标，返回 true。
     * 4. 如果当前位置 i 超过了 maxReach，说明无法继续前进，返回 false。
     * 5. 返回 false（只有在无法到达最后一个下标的情况下才会执行到这一步）。
     * 
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

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
