package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {
    // 计算每一对数的距离，并相加
    // 大数据超时
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int totalDistance = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                totalDistance += hammingDistance(nums[i], nums[j]);
            }
        }
        return totalDistance;
    }

    private int hammingDistance(int x, int y) {
        int distance = 0;
        while (x != 0 || y != 0) {
            int i = 0;
            int j = 0;
            if (x != 0) {
                i = x & 1;
                x = x >> 1;
            }
            if (y != 0) {
                j = y & 1;
                y = y >> 1;
            }
            if (i != j) {
                distance++;
            }
        }
        return distance;
    }
}
