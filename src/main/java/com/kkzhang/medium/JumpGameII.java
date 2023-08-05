package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    /**
     * 解题思路：
     * 这道题可以使用贪心算法来解决。我们可以在每一步选择可以跳跃的范围内，选择能够跳到最远位置的下一步。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 curEnd 为 0，curFarthest 为 0，jumps 为 0。
     * 2. 遍历数组，对于每个位置 i，执行以下操作：
     * * 2.1 更新 curFarthest 为 max(curFarthest, i + nums[i])，表示在当前位置可以跳到的最远位置。
     * * 2.2 如果当前位置等于 curEnd，说明已经跳到了上一步能跳到的最远位置，需要更新 curEnd 为 curFarthest，并增加 jumps。
     * 3. 循环结束后，jumps 即为到达最后一个位置所需的最小跳跃次数。
     * 
     * 
     */
    public static int jump2(int[] nums) {
        int curEnd = 0;
        int curFarthest = 0;
        int step = 0;

        // curEnd 表示上一次跳的最远位置
        // curFarthest 表示在 curEnd 内能够跳的最远位置
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            // if (curFarthest == i + nums[i]) {
            // System.out.println("当前位置：" + i);
            // }
            if (i == curEnd) {
                curEnd = curFarthest;
                step++;
            }
        }

        return step;
    }

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
