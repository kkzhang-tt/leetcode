package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumOfSquareNumbers {
    // two pointers
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        int l = 0;
        // 转换成 int 不能通过所有 test case
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long sum = l * l + r * r;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}
