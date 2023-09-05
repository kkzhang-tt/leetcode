package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return true;
    }

    // chagpt generation
    /**
     * 解题思路：
     * 这个问题可以使用二分查找来解决，以减少调用 isBadVersion 的次数。
     * 
     * 具体步骤如下：
     * 1. 使用二分查找，初始化左边界 left 为 1，右边界 right 为 n。
     * 2. 在每次迭代中，计算中间版本 mid，并调用 isBadVersion(mid) 来判断 mid 是否是坏版本。
     * 3. 如果 mid 是坏版本，说明第一个坏版本在 mid 左边，将右边界 right 更新为 mid。
     * 4. 如果 mid 不是坏版本，说明第一个坏版本在 mid 右边，将左边界 left 更新为 mid + 1。
     * 5. 当 left 和 right 相等时，说明找到了第一个坏版本，返回 left。
     */
    /**
     * public class Solution extends VersionControl {
            public int firstBadVersion(int n) {
                int left = 1;
                int right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (isBadVersion(mid)) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                return left;
            }
        }
     */
}
