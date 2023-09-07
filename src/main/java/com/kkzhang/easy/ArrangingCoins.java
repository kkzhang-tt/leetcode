package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }

        int level = 1;
        int count = 0;
        while (n >= level) {
            n -= level;
            level++;
            count++;
        }
        return count;
    }

    /**
     * 解题思路：
     * 我们可以通过二分查找的方法来解决这个问题。
     * 
     * 具体步骤如下：
     * 1. 初始化左边界 left 为 1，右边界 right 为 n。
     * 2. 在每次迭代中，计算中间值 mid，并根据 mid 行能摆放的硬币数量与 n 的关系来更新左右边界。
     * * 2.1 如果 mid * (mid + 1) / 2 <= n，说明 mid 行能够摆放的硬币数量小于等于 n，将左边界 left 更新为 mid + 1。
     * * 2.2 如果 mid * (mid + 1) / 2 > n，说明 mid 行能够摆放的硬币数量大于 n，将右边界 right 更新为 mid。
     * 3. 最终，返回左边界 left - 1 即为可形成完整阶梯行的总行数。
     */
    /**
     * class Solution {
            public int arrangeCoins(int n) {
                long left = 1;
                long right = n;
                while (left <= right) {
                    long mid = left + (right - left) / 2;
                    long coinsInMidRows = mid * (mid + 1) / 2;
                    if (coinsInMidRows <= n) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return (int) left - 1;
            }
        }
     */
}
