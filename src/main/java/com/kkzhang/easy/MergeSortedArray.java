package com.kkzhang.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
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
