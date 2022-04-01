package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    // 想要面积最大，首先保证长度较长
    // 通过双指针，在缩减长度的同时，选取较大的高度，使得面积近可能大
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            int curArea = 0;
            int with = right - left;
            if (height[left] < height[right]) {
                curArea = height[left] * with;
                left++;
            } else {
                curArea = height[right] * with;
                right--;
            }
            max = Math.max(max, curArea);
        }
        return max;
    }
}
