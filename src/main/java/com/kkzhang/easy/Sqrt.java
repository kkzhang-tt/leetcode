package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    /**
     * 解题思路：
     * 这道题可以使用二分搜索来逼近平方根的整数部分。
     * 在平方根范围内，最大的可能的平方根整数部分就是 x 本身。
     * 
     * 具体步骤如下：
     * 1. 初始化左边界 left 为0，右边界 right 为 x。
     * 2. 进入循环，当左边界小于等于右边界时，执行以下操作：
     * * 2.1 计算中间位置 mid。
     * * 2.2 如果 mid * mid 小于等于 x，说明平方根的整数部分在 mid 的右边，将 left 更新为 mid + 1。
     * * 2.3 否则，说明平方根的整数部分在 mid 的左边，将 right 更新为 mid - 1。
     * 3. 循环结束时，返回 right。
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 闭区间
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return sqrt;
            } else if (sqrt < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // binary search
    public int mySqrt2(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
