package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    /**
     * 解题思路：
     * 这道题可以使用贪心算法来解决。贪心算法的思想是每次选择当前可达范围内的最大跳跃距离。
     * 
     * 具体步骤如下：
     * 1. 初始化变量 maxPosition 为 0，表示当前可达的最远位置。
     * 2. 初始化变量 end 为 0，表示当前跳跃的边界，即在 end 范围内选择下一次跳跃的最远位置。
     * 3. 初始化变量 steps 为 0，表示跳跃次数。
     * 4. 进入循环，从第一个位置开始遍历到倒数第二个位置（nums.length - 1），执行以下操作：
     * * 4.1 在当前可达范围内，更新最远位置 maxPosition，即 maxPosition = max(maxPosition, i +
     * nums[i])。
     * * 4.2 如果当前位置 i 到达了当前跳跃的边界 end，说明需要进行下一次跳跃，将 end 更新为 maxPosition，并增加跳跃次数
     * steps++。
     * 5. 循环结束后，返回跳跃次数 steps。
     * 
     */
    public int jump2(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int curEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (curEnd == i) {
                curEnd = maxPosition;
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
