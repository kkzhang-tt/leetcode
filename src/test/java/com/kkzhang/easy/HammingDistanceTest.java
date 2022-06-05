package com.kkzhang.easy;

import org.junit.Test;

public class HammingDistanceTest {

    private HammingDistance solution = new HammingDistance();

    @Test
    public void testHammingDistance() {
        int x = 3;
        int y = 1;
        int distance = solution.hammingDistance(x, y);
        System.out.print(distance);
    }
}
