package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

    // 贪心算法
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int totalCount = 0;
        // 从左向右遍历
        for (int i = 0; i < l; i++) {
            // 如果当前元素值 0
            if (flowerbed[i] == 0) {
                // 如果当前位置为最后一个元素，则其下一个位置可以看作是 0
                int next = i == l - 1 ? 0 : flowerbed[i + 1];
                // 如果当前位置为第一个元素，则其前一个位置可以看作是 0
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                if (next == 0 && pre == 0) {
                    flowerbed[i] = 1;
                    totalCount++;
                }
            }
        }
        return totalCount >= n;
    }
}
