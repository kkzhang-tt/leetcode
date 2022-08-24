package com.kkzhang.easy;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortedArrayTest {
    private MergeSortedArray solution = new MergeSortedArray();

    @Test
    public void testMergeSortedArray() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.print(Arrays.toString(nums1));
    }

    @Test
    public void testMergeSortedArray2() {
        int[] nums1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{};
        int n = 0;
        solution.merge(nums1, m, nums2, n);
        System.out.print(Arrays.toString(nums1));
    }
}
