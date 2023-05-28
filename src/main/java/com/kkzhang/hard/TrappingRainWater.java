package com.kkzhang.hard;

/**
 * https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&id=top-interview-150
 */
public class TrappingRainWater {
    /**
     * 解题思路：
     * 题目要求计算给定高度图下雨后能接的水总量。可以通过遍历高度图，计算每个位置能接到的水的量。
     * 
     * 具体步骤如下：
     * 
     * 1. 初始化变量left和right分别为左边最高高度和右边最高高度的数组，长度与高度图相同。
     * * left[i]表示位置i左边（包括i）最高的柱子高度。
     * * right[i]表示位置i右边（包括i）最高的柱子高度。
     * 2. 遍历高度图，从左到右更新left数组。对于每个位置i，left[i]等于max(left[i-1],
     * * height[i])，表示当前位置左边最高柱子的高度。
     * 3. 遍历高度图，从右到左更新right数组。对于每个位置i，right[i]等于max(right[i+1],
     * * height[i])，表示当前位置右边最高柱子的高度。
     * 4. 初始化变量water为0，表示接到的水的总量。
     * 5. 遍历高度图，对于每个位置i，计算当前位置能接到的水的量，即min(left[i], right[i]) -
     * height[i]，并累加到water中。
     * 6. 返回water。
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }
}
