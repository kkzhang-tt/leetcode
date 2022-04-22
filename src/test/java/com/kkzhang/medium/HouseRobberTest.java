package com.kkzhang.medium;

import org.junit.Test;

public class HouseRobberTest {
    private HouseRobber solution = new HouseRobber();

    @Test
    public void testRob() {
        int[] nums = new int[] { 1, 2, 3, 1 };
        int max = solution.rob(nums);
        System.out.print(max);
    }
}
