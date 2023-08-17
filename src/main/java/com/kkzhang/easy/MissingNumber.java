package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    /**
     * 解题思路：
     * 这道题可以通过计算缺失的数的总和，然后减去数组中所有数的总和，得到结果。
     * 
     * 具体步骤如下：
     * 1. 计算 0 到 n 的和，即 totalSum = n * (n + 1) / 2。
     * 2. 遍历数组，计算数组中所有数的总和，即 arraySum。
     * 3. 返回 totalSum - arraySum，即为缺失的数。
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = n * (n + 1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return expectSum - sum;
    }
}
