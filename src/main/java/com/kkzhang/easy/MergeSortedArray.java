package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    /**
     * 解题思路：
     * 这道题可以使用双指针的方法来解决。由于 nums1 和 nums2 都是有序的，我们可以从两个数组的末尾开始比较元素，并将较大的元素放在 nums1
     * 的末尾。
     * 
     * 具体步骤如下：
     * 1. 初始化指针 p1 指向 nums1 的第 m-1 个元素，指针 p2 指向 nums2 的第 n-1 个元素，指针 p 指向 nums1
     * 的最后一个位置（m + n - 1）。
     * 2. 进入循环，当 p1 和 p2 都大于等于 0 时，执行以下操作：
     * * 2.1 如果 nums1[p1] 大于等于 nums2[p2]，将 nums1[p1] 放在 nums1[p] 的位置，并将 p1 和 p
     * 同时左移一位。
     * * 2.2 否则，将 nums2[p2] 放在 nums1[p] 的位置，并将 p2 和 p 同时左移一位。
     * 3. 如果 p2 大于等于 0，说明 nums2 中还有元素未放置到 nums1 中，将剩余的 nums2 中的元素依次放置到 nums1 中。
     * 
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            int v1 = nums1[p1];
            int v2 = nums2[p2];
            if (v1 >= v2) {
                nums1[p] = v1;
                p1--;
            } else {
                nums1[p] = v2;
                p2--;
            }
            p--;
        }
        
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int index_3 = m + n - 1; // 最终数组索引
        int index_2 = n - 1; // nums2 索引
        int index_1 = m - 1; // nums1 索引
        // 从右向左遍历
        while (index_3 >= 0) {
            int value = 0;
            if (index_1 >= 0 && index_2 >= 0) { // 两个数组都有元素
                if (nums1[index_1] >= nums2[index_2]) {
                    value = nums1[index_1];
                    index_1--;
                } else {
                    value = nums2[index_2];
                    index_2--;
                }
            } else if (index_1 >= 0) { // 只有数组 1 有元素
                value = nums1[index_1];
                index_1--;
            } else { // 只有数组 2 有元素
                value = nums2[index_2];
                index_2--;
            }

            nums1[index_3] = value;
            index_3--;
        }
    }
}
