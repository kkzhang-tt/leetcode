package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {
    // i & 1 用于判断最右边位的值：1 or 0
    // i >> 1 右移一位
    public int hammingDistance(int x, int y) {
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
