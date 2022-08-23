package com.kkzhang.easy;

import org.junit.Test;

public class CanPlaceFlowersTest {
    private CanPlaceFlowers solution = new CanPlaceFlowers();

    @Test
    public void testCanPlaceFlowers() {
        int[] flowerbed = new int[]{1, 0, 0, 0, 0, 1};
        boolean res = solution.canPlaceFlowers(flowerbed, 2);
        System.out.print(res);
    }
}
