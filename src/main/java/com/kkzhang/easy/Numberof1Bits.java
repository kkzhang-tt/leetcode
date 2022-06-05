package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    // “去 1 法”：n & n-1 去除 n 最右边的 1
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
