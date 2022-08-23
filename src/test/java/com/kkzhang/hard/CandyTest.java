package com.kkzhang.hard;

import org.junit.Test;

public class CandyTest {
    private Candy solution = new Candy();

    @Test
    public void testCandy() {
        int[] ratings = new int[]{1, 2, 2};
        int minimum = solution.candy(ratings);
        System.out.print(minimum);
    }
}
