package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    /**
     * 解题思路：
     * 这道题可以使用动态规划来解决。定义一个数组 dp，其中 dp[i] 表示偷窃到第 i 个房屋时能够获得的最高金额。
     * 
     * 具体步骤如下：
     * 1. 初始化 dp 数组，其中 dp[0] 表示偷窃到第 0 个房屋的最高金额，dp[1] 表示偷窃到第 1 个房屋的最高金额。
     * 2. 进入循环，从第 2 个房屋开始遍历到第 n 个房屋，执行以下操作：
     * 3. 计算当前房屋偷窃的最高金额。有两种情况：
     * * 如果偷窃当前房屋，则最高金额为 dp[i-2] + nums[i]，即偷窃到前两个房屋的最高金额加上当前房屋的金额。
     * * 如果不偷窃当前房屋，则最高金额为 dp[i-1]，即偷窃到前一个房屋的最高金额。
     * * 在这两种情况中选择较大的金额作为当前房屋的最高金额，即 dp[i] = max(dp[i-2] + nums[i], dp[i-1])。
     * 4. 循环结束后，dp[n-1] 即为偷窃到最后一个房屋的最高金额，返回 dp[n-1]。
     * 
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        if (n > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

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

    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
