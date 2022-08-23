package com.kkzhang.medium;

import org.junit.Test;

public class NonDecreasingArrayTest {
    private NonDecreasingArray solution = new NonDecreasingArray();

    @Test
    public void testNonDecreasingArray() {
        int[] nums = new int[]{4, 2, 1};
        boolean res = solution.checkPossibility(nums);
        System.out.print(res);
    }
}
