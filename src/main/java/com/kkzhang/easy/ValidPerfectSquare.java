package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    /**
     * 解题思路：
     * 判断一个数是否为完全平方数，一种常见的方法是通过循环递增的方式来尝试每个可能的完全平方数，然后与给定的数进行比较。但这种方法的时间复杂度较高，不够高效。
     * 更高效的方法是使用二分查找，因为完全平方数的平方根肯定是一个整数。
     * 
     * 具体思路如下：
     * 1. 初始化左边界 left 为 1，右边界 right 为 num。
     * 2. 在每次迭代中，计算中间值 mid，并计算 mid 的平方。
     * 3. 如果 mid 的平方等于 num，说明 num 是完全平方数，返回 true。
     * 4. 如果 mid 的平方小于 num，说明 num 在 mid 的右边，将左边界 left 更新为 mid + 1。
     * 5. 如果 mid 的平方大于 num，说明 num 在 mid 的左边，将右边界 right 更新为 mid - 1。
     * 6. 最终，如果没有找到完全平方数，返回 false。
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }

        if (num == 0 || num == 1) {
            return true;
        }

        int left = 2, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            double v = (double) num / mid;
            if (v == mid) {
                return true;
            } else if (v < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // chatgpt generation
    /**
     * class Solution {
            public boolean isPerfectSquare(int num) {
                if (num < 2) {
                    return true;
                }
                
                long left = 1;
                long right = num;
                
                while (left <= right) {
                    long mid = left + (right - left) / 2;
                    long square = mid * mid;
                    if (square == num) {
                        return true;
                    } else if (square < num) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                return false;
            }
        }
     */
}
