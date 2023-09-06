package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower {

    /**
     * 解题思路：
     * 这道题要求在给定范围 [1, n] 内猜测一个数字，通过与系统交互来确定数字。
     * 我们可以使用二分查找来快速确定数字。
     * 
     * 具体思路如下：
     * 1. 初始化左边界 left 为 1，右边界 right 为 n。
     * 2. 在每次迭代中，计算中间值 mid。
     * 3. 调用 guess(mid) 方法，根据返回值的大小关系来更新左右边界。
     * 4. 如果 guess(mid) 返回 -1，说明目标数字在 mid 的左边，将 right 更新为 mid - 1。
     * 5. 如果 guess(mid) 返回 1，说明目标数字在 mid 的右边，将 left 更新为 mid + 1。
     * 6. 如果 guess(mid) 返回 0，说明找到了目标数字，返回 mid。
     * 7. 最终，如果没有找到目标数字，返回 -1。
     */
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    int guess(int num) {
        return 0;
    }
}
