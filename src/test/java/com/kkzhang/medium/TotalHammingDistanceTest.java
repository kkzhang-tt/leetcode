package com.kkzhang.medium;

import org.junit.Test;

public class TotalHammingDistanceTest {

    private TotalHammingDistance solution = new TotalHammingDistance();

    @Test
    public void testTotalHammingDistance() {
        int[] nums = new int[] { 4, 14, 4 };
        int res = solution.totalHammingDistance(nums);
        System.out.print(res);
    }
}
