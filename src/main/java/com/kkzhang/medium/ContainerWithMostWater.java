package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    /**
     * 解题思路：
     * 这道题可以使用双指针的方法来解决。
     * 我们可以从数组的两端分别设置指针 left 和
     * right，然后计算两个指针之间的距离和高度构成的面积。由于容器的容量取决于较短的那一根柱子，我们可以不断移动较短柱子所在的指针，直到两个指针相遇。
     * 
     * 具体步骤如下：
     * 1. 初始化指针 left 为 0，指针 right 为数组的长度减 1。
     * 2. 进入循环，当 left 小于 right 时，执行以下操作：
     * * 2.1 计算指向的两个柱子之间的距离 width。
     * * 2.2 计算指向的两个柱子之间的高度 h，为 height[left] 和 height[right] 中较小的那个。
     * * 2.3 计算容器的容量 area，为 width * h。
     * * 2.4 将 area 与之前计算得到的最大容量 maxArea 进行比较，将较大值更新到 maxArea 中。
     * * 2.5 如果 height[left] 小于 height[right]，将 left 右移一位；否则，将 right 左移一位。
     * 3. 循环结束后，返回 maxArea，即为容器可以容纳的最大水量。
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            if (height[left] <= height[right]) {
                max = Math.max(max, width * height[left]);
                left++;
            } else {
                max = Math.max(max, width * height[right]);
                right--;
            }
        }
        return max;
    }

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
