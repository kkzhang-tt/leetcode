package com.kkzhang.hard;

/**
 * https://leetcode.com/problems/candy/
 */
public class Candy {
    // 贪心算法
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }
        // init
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        // 从左到右遍历
        for (int i = 1; i < n; i++) {
            // 如果右边孩子比左边高，则其糖果数等于左边孩子的糖果数 +1
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        // 从右到左遍历
        for (int i = n - 2; i >= 0; i--) {
            // 如果左边孩子比右边高，且左边孩子的糖果数不大于右边孩子，则其糖果数等于右边孩子的糖果数 +1
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }

        int minimum = 0;
        for (int i = 0; i < n; i++) {
            minimum += res[i];
        }

        return minimum;
    }
}
