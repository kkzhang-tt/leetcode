package com.kkzhang.medium;

import java.util.List;

import org.junit.Test;

public class LargestDivisibleSubsetTest {

    private LargestDivisibleSubset solution = new LargestDivisibleSubset();

    @Test
    public void testLargestDivisibleSubset() {
        int[] nums = new int[] { 4, 8, 10, 240 };
        List<Integer> res = solution.largestDivisibleSubset(nums);
        System.out.println(res);
    }
}
