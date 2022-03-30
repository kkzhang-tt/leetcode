package com.kkzhang.easy;

import org.junit.Test;

public class MaximumSubarrayTest {
    @Test
    public void maxSubArray() {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(MaximumSubarray.maxSubArray(nums));
    }
}
