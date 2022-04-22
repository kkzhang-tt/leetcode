package com.kkzhang.medium;

import org.junit.Test;

public class HouseRobberIITest {

    private HouseRobberII solution = new HouseRobberII();

    @Test
    public void testRob() {
        int[] nums = new int[] { 200, 3, 140, 20, 10 };
        int max = solution.rob(nums);
        System.out.print(max);
    }
}
