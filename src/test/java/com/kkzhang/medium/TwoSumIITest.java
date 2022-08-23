package com.kkzhang.medium;

import org.junit.Test;

public class TwoSumIITest {
    private TwoSumII solution = new TwoSumII();

    @Test
    public void testTwoSumII() {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = solution.twoSum(nums, 9);
        System.out.print(res[0] + " " + res[1]);
    }
}
