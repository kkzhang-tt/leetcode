package com.kkzhang.medium;

import org.junit.Test;

public class MaximumProductSubarrayTest {
    private MaximumProductSubarray soulution = new MaximumProductSubarray();

    @Test
    public void testMaximumProductSubarray() {
        int[] nums = new int[] { 2, -5, -2, -4, 3};
        System.out.println(soulution.maxProduct_1(nums));
    }
}
