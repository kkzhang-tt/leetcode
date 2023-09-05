package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndexII {

    /**
     * 解题思路：
     * 这个问题可以使用二分查找来解决。
     * 由于数组 citations 是升序排列的，我们可以使用二分查找来找到研究者的 h 指数。
     * 
     * 具体思路如下：
     * 1. 初始化左边界 left 为 0，右边界 right 为数组长度减 1。
     * 2. 在每次迭代中，计算中间位置 mid。
     * 3. 比较 citations[mid] 和 n - mid（其中 n 是数组长度），即表示有 n - mid 篇论文至少被引用了 citations[mid]
     * * * 次。
     * 4. 如果 citations[mid] 大于或等于 n - mid，说明 mid 可能是一个有效的 h 指数，将右边界 right 更新为 mid -
     * * * 1，继续查找左半部分。
     * 5. 如果 citations[mid] 小于 n - mid，说明 mid 不是有效的 h 指数，将左边界 left 更新为 mid +
     * * * 1，继续查找右半部分。
     * 6. 最终返回 left 作为研究者的 h 指数。
     */
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = citations[mid];
            if (citations.length - mid > val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }
}
